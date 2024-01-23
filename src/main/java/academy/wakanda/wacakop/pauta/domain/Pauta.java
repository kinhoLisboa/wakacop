package academy.wakanda.wacakop.pauta.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@ToString
@Getter
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String titulo;
    private String descrica;
    private UUID idAssociado;
    private LocalDateTime dataCriacao;
}
