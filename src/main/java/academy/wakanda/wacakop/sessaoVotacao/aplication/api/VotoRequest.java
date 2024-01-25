package academy.wakanda.wacakop.sessaoVotacao.aplication.api;

import academy.wakanda.wacakop.sessaoVotacao.domain.OpcaoVoto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VotoRequest {
    private String cpfAssociado;
    private OpcaoVoto opcao;


}
