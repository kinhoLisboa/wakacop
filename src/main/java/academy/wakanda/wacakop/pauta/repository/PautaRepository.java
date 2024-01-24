package academy.wakanda.wacakop.pauta.repository;

import academy.wakanda.wacakop.pauta.domain.Pauta;

import java.util.UUID;

public interface PautaRepository {
    Pauta salva(Pauta pauta);

    Pauta buscaPautaPorId(UUID idPauta);
}
