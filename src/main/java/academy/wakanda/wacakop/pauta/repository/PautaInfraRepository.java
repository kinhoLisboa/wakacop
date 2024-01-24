package academy.wakanda.wacakop.pauta.repository;

import academy.wakanda.wacakop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PautaInfraRepository implements PautaRepository {

    private final PautaJpaRepository pautaJpaRepository;
    @Override
    public Pauta salva(Pauta pauta) {
        log.info("[Start] PautaInfraRepository - salva");
        pautaJpaRepository.save(pauta);
        log.info("[Finish] PautaInfraRepository - salva");
        return pauta;
    }

    @Override
    public Pauta buscaPautaPorId(UUID idPauta) {
        log.info("[Start] PautaInfraRepository - buscaPautaPorId");
        Pauta  pautaPorId = pautaJpaRepository.findById(idPauta)
                .orElseThrow(()->new RuntimeException("Pauta não encontrada!"));
        log.info("[Finish] PautaInfraRepository - buscaPautaPorId");
        return pautaPorId;
    }
}
