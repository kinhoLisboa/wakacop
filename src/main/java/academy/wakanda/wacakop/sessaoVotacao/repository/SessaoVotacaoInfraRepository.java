package academy.wakanda.wacakop.sessaoVotacao.repository;

import academy.wakanda.wacakop.sessaoVotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoInfraRepository implements SessaoVotacaoRepository {

    private final SessaoVotacaoJpaRepository sessaoVotacaoJpaRepository;
    @Override
    public SessaoVotacao salva(SessaoVotacao sessaoVotacao) {
        log.info("[Start] SessaoVotacaoInfraRepository- salva");
        sessaoVotacaoJpaRepository.save(sessaoVotacao);
        log.info("[Finish] SessaoVotacaoInfraRepository- salva");
        return sessaoVotacao;
    }

    @Override
    public SessaoVotacao buscaPorId(UUID idSessao) {
        log.info("[Start] SessaoVotacaoInfraRepository- salva");
       SessaoVotacao sessao = sessaoVotacaoJpaRepository.findById(idSessao)
                        .orElseThrow(()-> new RuntimeException("Sessao nao encontrada!")) ;
        log.info("[Finish] SessaoVotacaoInfraRepository- salva");
        return sessao;
    }
}
