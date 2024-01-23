package academy.wakanda.wacakop.pauta.service;

import academy.wakanda.wacakop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.wacakop.pauta.application.api.PautaCadastradaResponse;

public interface PautaService {
    PautaCadastradaResponse cadastrapauta(NovaPautaRequest novaPauta);
}
