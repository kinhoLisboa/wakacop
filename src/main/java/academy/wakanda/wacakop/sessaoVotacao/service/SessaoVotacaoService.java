package academy.wakanda.wacakop.sessaoVotacao.service;

import academy.wakanda.wacakop.sessaoVotacao.aplication.api.*;

import java.util.UUID;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);

    VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto);

    ResultadoSessaoResponse obtemResultado(UUID idSessao);
}
