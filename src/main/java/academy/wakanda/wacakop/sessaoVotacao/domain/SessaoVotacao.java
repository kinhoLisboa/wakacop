package academy.wakanda.wacakop.sessaoVotacao.domain;

import academy.wakanda.wacakop.pauta.domain.Pauta;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.ResultadoSessaoResponse;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaRequest;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.VotoRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDateTime;
import java.util.*;

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
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKey(name= "cpfAssociado")
    private Map<String, VotoPauta> votos;

    public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest, Pauta pauta) {
        this.idPauta = pauta.getId();
        this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
        this.dataAbertura = LocalDateTime.now();
        this.dataEncerramento = dataAbertura.plusMinutes(this.tempoDuracao);
        this.status = StatusSessaoVotacao.ABERTA;
        this.votos = new HashMap<>();
    }
    public ResultadoSessaoResponse obtemResultado(){
        atualizaStatus();
        return new ResultadoSessaoResponse(this);

    }

    public VotoPauta recebeVoto(VotoRequest votoRequest){
        validaSessaoAberta();
       validaAssociado(votoRequest.getCpfAssociado());
       VotoPauta voto = new VotoPauta(this, votoRequest);
       votos.put(votoRequest.getCpfAssociado(),voto);
       return voto;
    }

    private void validaSessaoAberta() {
        atualizaStatus();
        if(this.status.equals(StatusSessaoVotacao.FECHADA)){
            throw new RuntimeException("Sessao esta fechada!");
        }
    }
    private void atualizaStatus(){
        if(this.status.equals(StatusSessaoVotacao.ABERTA)){
            if(LocalDateTime.now().isAfter(this.dataEncerramento)){
                fechaSessao();
            }
        }
    }

    private void fechaSessao() {
        this.status = StatusSessaoVotacao.FECHADA;

    }

    private void validaAssociado(String cpfAssociado) {
        if(this.votos.containsKey(cpfAssociado)) {
            new RuntimeException("Associado ja votou nessa sessao !");
        }

    }


    public Long getTotalVotos() {
        return Long.valueOf(this.votos.size());
    }

    public Long getTotalSim() {
        calculaVotosPorOpcao(OpcaoVoto.SIM);
        return calculaVotosPorOpcao(OpcaoVoto.SIM);
    }
    public Long getTotalNao() {
        calculaVotosPorOpcao(OpcaoVoto.NAO);
        return calculaVotosPorOpcao(OpcaoVoto.NAO);
    }

    private Long calculaVotosPorOpcao(OpcaoVoto opcao) {
        return votos.values()
                .stream().filter(votos -> votos.opcaoIgual(opcao))
                .count();
    }
}
