package github.jadilson22a.APICompras.Services;

import github.jadilson22a.APICompras.Models.Cotacao;
import github.jadilson22a.APICompras.Models.Produtos;
import github.jadilson22a.APICompras.Repositorys.CotacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class CotacaoService {

    private CotacaoRepository repository;

    public CotacaoService(CotacaoRepository repository) {
        this.repository = repository;
    }

    public void inserirCotacao(Cotacao cotacao){
        for (Produtos p : cotacao.getProdutos()) {
            p.setCotacao(cotacao); // seta a relação de volta
        }
        repository.save(cotacao);
    }
}
