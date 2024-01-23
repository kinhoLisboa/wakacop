package academy.wakanda.wacakop.pauta.repository;

import academy.wakanda.wacakop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PautaInfraRepository implements PautaRepository {

    private final PautaJpaRepository pautaJpaRepository;
    @Override
    public Pauta salva(Pauta pauta) {
        log.info("[Start] PautaAplicationRepository - salva");
        pautaJpaRepository.save(pauta);
        log.info("[Finish] PautaAplicationRepository - salva");
        return pauta;
    }
}
