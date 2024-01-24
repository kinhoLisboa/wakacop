package academy.wakanda.wacakop.pauta.service;

import academy.wakanda.wacakop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.wacakop.pauta.application.api.PautaCadastradaResponse;
import academy.wakanda.wacakop.pauta.domain.Pauta;

import java.util.UUID;

public interface PautaService {
    PautaCadastradaResponse cadastrapauta(NovaPautaRequest novaPauta);

    Pauta getPautaPorId(UUID idPauta);
}
