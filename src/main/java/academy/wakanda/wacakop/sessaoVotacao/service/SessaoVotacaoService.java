package academy.wakanda.wacakop.sessaoVotacao.service;

import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaRequest;
import academy.wakanda.wacakop.sessaoVotacao.aplication.api.SessaoAberturaResponse;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
}
