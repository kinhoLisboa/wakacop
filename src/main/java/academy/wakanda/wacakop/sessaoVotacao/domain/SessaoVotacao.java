package academy.wakanda.wacakop.sessaoVotacao.domain;

import academy.wakanda.wacakop.pauta.domain.Pauta;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaRequest;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.VotoRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoVotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private UUID idPauta;
    private Integer tempoDuracao;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    @Enumerated(EnumType.STRING)
    private StatusSessaoVotacao status;
    @OneToMany(mappedBy = "sessaoVotacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private HashMap<String, VotoPauta> votos;

    public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest, Pauta pauta) {
        this.idPauta = pauta.getId();
        this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
        this.dataAbertura = LocalDateTime.now();
        this.dataEncerramento = dataAbertura.plusMinutes(this.tempoDuracao);
        this.status = StatusSessaoVotacao.ABERTA;
        this.votos = new HashMap<>();
    }

    public VotoPauta recebeVoto(VotoRequest votoRequest){
       validaAssociado(votoRequest.getCpfAssociado());
       VotoPauta voto = new VotoPauta(this, votoRequest);
       votos.put(votoRequest.getCpfAssociado(),voto);
       return voto;
    }

    private void validaAssociado(String cpfAssociado) {
        if(this.votos.containsKey(cpfAssociado)) {
            new RuntimeException("Associado ja votou nessa sessao !");
        }

    }


}
