package academy.wakanda.wacakop.sessaoVotacao.aplication.api;

import academy.wakanda.wacakop.sessaoVotacao.domain.SessaoVotacao;
import academy.wakanda.wacakop.sessaoVotacao.domain.StatusSessaoVotacao;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class ResultadoSessaoResponse {

    private UUID id;
    private UUID idPauta;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    private StatusSessaoVotacao status;
    private Long totalVotos;
    private Long totalSim;
    private Long totalNao;

    public ResultadoSessaoResponse(SessaoVotacao sessao) {
        this.id = sessao.getId();
        this.idPauta = sessao.getIdPauta();
        this.dataAbertura = sessao.getDataAbertura();
        this.dataEncerramento = sessao.getDataEncerramento();
        this.status = sessao.getStatus();
        this.totalVotos = sessao.getTotalVotos();
        this.totalSim = sessao.getTotalSim();
        this.totalNao = sessao.getTotalNao();
    }
}
