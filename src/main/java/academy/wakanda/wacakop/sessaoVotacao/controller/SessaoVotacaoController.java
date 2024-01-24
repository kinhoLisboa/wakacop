package academy.wakanda.wacakop.sessaoVotacao.controller;

import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaRequest;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaResponse;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoVotacaoApi;
import academy.wakanda.wacakop.sessaoVotacao.service.SessaoVotacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
