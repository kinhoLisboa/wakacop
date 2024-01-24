package academy.wakanda.wacakop.sessaoVotacao.repository;

import academy.wakanda.wacakop.sessaoVotacao.domain.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessaoVotacaoJpaRepository extends JpaRepository<SessaoVotacao, UUID> {
}
