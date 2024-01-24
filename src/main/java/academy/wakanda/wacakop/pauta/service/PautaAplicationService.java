package academy.wakanda.wacakop.pauta.service;

import academy.wakanda.wacakop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.wacakop.pauta.application.api.PautaCadastradaResponse;
import academy.wakanda.wacakop.pauta.domain.Pauta;
import academy.wakanda.wacakop.pauta.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaAplicationService implements PautaService {

    private final PautaRepository pautaRepository;

    @Override
    public PautaCadastradaResponse cadastrapauta(NovaPautaRequest novaPauta) {
        log.info("[Start] PautaAplicationService - cadastraPauta");
        log.info("[novaPauta] ", novaPauta);
        Pauta pauta = pautaRepository.salva(new Pauta(novaPauta));
        log.info("[Finish] PautaAplicationService - cadastraPauta");
        return new PautaCadastradaResponse(pauta);
    }

    @Override
    public Pauta getPautaPorId(UUID idPauta) {
        log.info("[Start] PautaAplicationService - getPautaPorId");
        Pauta pautaPorId =  pautaRepository.buscaPautaPorId(idPauta);
        log.info("[Finish] PautaAplicationService - getPautaPorId");
        return pautaPorId;
    }
}
