package academy.wakanda.wacakop.sessaoVotacao.aplication.api;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;
import java.util.UUID;

@ToString
public class SessaoAberturaRequest {
    @Getter
    @NotNull
    private UUID idPauta;
    private Integer tempoDuaraco;

    public Optional<Integer> getTempoDuracao(){
        return Optional.ofNullable(this.tempoDuaraco);
    }
}
