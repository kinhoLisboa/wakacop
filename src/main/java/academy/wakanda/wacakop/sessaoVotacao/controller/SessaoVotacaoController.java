package academy.wakanda.wacakop.sessaoVotacao.controller;

import academy.wakanda.wacakop.sessaoVotacao.aplication.api.*;
import academy.wakanda.wacakop.sessaoVotacao.service.SessaoVotacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoController implements SessaoVotacaoApi {

    private final SessaoVotacaoService sessaoVotacaoService;
    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[Start] SessaoVotacaoController- abreSessao");
        SessaoAberturaResponse sessaoAberturaResponse = sessaoVotacaoService.abreSessao(sessaoAberturaRequest);
        log.info("[Finish] SessaoVotacaoController- abreSessao");
        return sessaoAberturaResponse;
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
        log.info("[Start] SessaoVotacaoController- recebeVoto");
        log.info("[idSessao] {}", idSessao);
       VotoResponse votoResponse = sessaoVotacaoService.recebeVoto(idSessao, novoVoto);
        log.info("[Finish] SessaoVotacaoController- recebeVoto");
        return votoResponse;
    }

    @Override
    public ResultadoSessaoResponse obtemResultado(UUID idSessao) {
        log.info("[Start] SessaoVotacaoController- obtemResultado");
        ResultadoSessaoResponse resultado = sessaoVotacaoService.obtemResultado(idSessao);
        log.info("[Finish] SessaoVotacaoController- obtemResultado");
        return resultado;
    }


}
