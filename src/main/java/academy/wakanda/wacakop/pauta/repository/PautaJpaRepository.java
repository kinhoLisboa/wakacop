package academy.wakanda.wacakop.pauta.repository;

import academy.wakanda.wacakop.pauta.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PautaJpaRepository extends JpaRepository<Pauta, UUID> {
}
