package academy.wakanda.wacakop.sessaoVotacao.service;

import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaRequest;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaResponse;
import academy.wakanda.wacakop.sessaoVotacao.domain.SessaoVotacao;
import academy.wakanda.wacakop.sessaoVotacao.repository.SessaoVotacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoAplicationService implements SessaoVotacaoService {

    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[Start] SessaoVotacaoAplicationService- abreSessao");
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest));
        log.info("[Finish] SessaoVotacaoAplicationService- abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }
}
