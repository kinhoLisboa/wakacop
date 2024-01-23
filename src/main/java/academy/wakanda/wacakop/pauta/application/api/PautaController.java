package academy.wakanda.wacakop.pauta.application.api;

import academy.wakanda.wacakop.pauta.service.PautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PautaController implements PautaApi {

    private final PautaService pautaService;
    @Override
    public PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta) {
        log.info("[Start] PautaController - cadastraPauta");
        PautaCadastradaResponse  pautaCadastrada = pautaService.cadastrapauta(novaPauta);
        log.info("[Finish] PautaController - cadastraPauta");
        return pautaCadastrada;
    }
}
