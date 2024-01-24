package academy.wakanda.wacakop.sessaoVotacao.aplication.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessao/abertura")
public interface SessaoVotacaoApi {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SessaoAberturaResponse abreSessao(@RequestBody SessaoAberturaRequest sessaoAberturaRequest);
}
