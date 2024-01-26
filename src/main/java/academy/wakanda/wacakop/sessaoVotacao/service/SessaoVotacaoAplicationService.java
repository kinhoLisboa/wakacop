package academy.wakanda.wacakop.sessaoVotacao.service;

import academy.wakanda.wacakop.pauta.domain.Pauta;
import academy.wakanda.wacakop.pauta.service.PautaService;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaRequest;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaResponse;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.VotoRequest;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.VotoResponse;
import academy.wakanda.wacakop.sessaoVotacao.domain.SessaoVotacao;
import academy.wakanda.wacakop.sessaoVotacao.domain.VotoPauta;
import academy.wakanda.wacakop.sessaoVotacao.repository.SessaoVotacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoAplicationService implements SessaoVotacaoService {

    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaService pautaService;


    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[Start] SessaoVotacaoAplicationService- abreSessao");
        Pauta pauta = pautaService.getPautaPorId(sessaoAberturaRequest.getIdPauta());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest,pauta));
        log.info("[Finish] SessaoVotacaoAplicationService- abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
        log.info("[Start] SessaoVotacaoAplicationService- recebeVoto");
        SessaoVotacao sessao = sessaoVotacaoRepository.buscaPorId(idSessao);
       VotoPauta voto = sessao.recebeVoto(novoVoto);
        log.info("[Finish] SessaoVotacaoAplicationService- recebeVoto");
        return new VotoResponse(voto);
    }
}
