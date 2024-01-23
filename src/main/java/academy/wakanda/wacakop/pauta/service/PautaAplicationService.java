package academy.wakanda.wacakop.pauta.service;

import academy.wakanda.wacakop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.wacakop.pauta.application.api.PautaCadastradaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaAplicationService implements PautaService {
    @Override
    public PautaCadastradaResponse cadastrapauta(NovaPautaRequest novaPauta) {
        log.info("[Start] PautaAplicationService - cadastraPauta");
        log.info("[novaPauta] ", novaPauta);
        log.info("[Finish] PautaAplicationService - cadastraPauta");
        return null;
    }
}
