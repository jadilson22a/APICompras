package github.jadilson22a.APICompras.Controllers;

import github.jadilson22a.APICompras.Models.Cotacao;
import github.jadilson22a.APICompras.Services.CotacaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    private CotacaoService service;

    public CotacaoController(CotacaoService service) {
        this.service = service;
    }

    @PostMapping
    public void inserirCotacao(@RequestBody Cotacao cotacao){
        service.inserirCotacao(cotacao);
    }
}
