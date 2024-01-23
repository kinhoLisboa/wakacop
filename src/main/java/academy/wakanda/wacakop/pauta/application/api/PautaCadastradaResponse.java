package academy.wakanda.wacakop.pauta.application.api;

import academy.wakanda.wacakop.pauta.domain.Pauta;
import lombok.Value;

import java.util.UUID;
@Value
public class PautaCadastradaResponse {
    private UUID id;

    public PautaCadastradaResponse(Pauta pauta) {
        this.id = pauta.getId();
    }
}
