package academy.wakanda.wacakop.sessaoVotacao.aplication.api;

import academy.wakanda.wacakop.sessaoVotacao.domain.SessaoVotacao;
import lombok.Data;

import java.util.UUID;
@Data
public class SessaoAberturaResponse {

    private UUID id;
    public SessaoAberturaResponse(SessaoVotacao sessaoVotacao) {
        this.id = sessaoVotacao.getId();
    }
}
