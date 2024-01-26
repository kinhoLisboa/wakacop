package academy.wakanda.wacakop.sessaoVotacao.repository;

import academy.wakanda.wacakop.sessaoVotacao.domain.SessaoVotacao;

import java.util.UUID;

public interface SessaoVotacaoRepository {
    SessaoVotacao salva(SessaoVotacao sessaoVotacao);

    SessaoVotacao buscaPorId(UUID idSessao);
}
