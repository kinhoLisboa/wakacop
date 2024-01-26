package academy.wakanda.wacakop.sessaoVotacao.service;

import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaRequest;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaResponse;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.VotoRequest;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.VotoResponse;

import java.util.UUID;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);

    VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto);
}
