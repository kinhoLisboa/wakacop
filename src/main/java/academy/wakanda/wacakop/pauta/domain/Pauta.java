package academy.wakanda.wacakop.pauta.domain;

import academy.wakanda.wacakop.pauta.application.api.NovaPautaRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String titulo;
    private String descricao;
    private UUID idAssociado;
    private LocalDateTime dataCriacao;

    public Pauta(NovaPautaRequest novaPauta) {
        this.titulo = novaPauta.getTitulo();
        this.descricao = novaPauta.getDescricao();
        this.idAssociado = novaPauta.getIdAssociado();
        this.dataCriacao = LocalDateTime.now();

    }


}
