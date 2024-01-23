package academy.wakanda.wacakop.pauta.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.UUID;
@Value
public class NovaPautaRequest {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descrica;
    @NotNull
    private UUID idAssociado;
}
