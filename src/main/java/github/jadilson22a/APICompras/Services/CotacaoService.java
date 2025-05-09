package github.jadilson22a.APICompras.Services;

import github.jadilson22a.APICompras.Models.Cotacao;
import github.jadilson22a.APICompras.Models.CotacaoStatus;
import github.jadilson22a.APICompras.Models.Fornecedores;
import github.jadilson22a.APICompras.Models.Produtos;
import github.jadilson22a.APICompras.Repositorys.CotacaoRepository;
import github.jadilson22a.APICompras.Repositorys.FornecedoresRepository;
import github.jadilson22a.APICompras.Repositorys.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CotacaoService {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    private FornecedoresRepository fornecedoresRepository;

    public CotacaoService(CotacaoRepository repository) {
        this.cotacaoRepository = repository;
    }

    public void inserirCotacao(Cotacao cotacao){
        cotacao.setDataCriada(LocalDate.now());
        cotacao.setStatus(CotacaoStatus.ABERTA);

        cotacaoRepository.save(cotacao);
    }

    public void inserirItens(List<Produtos> produtos, Integer idCotacao){
        var cotacao = cotacaoRepository.findById(idCotacao).orElse(null);

        // referencia cada produto a uma cotacao
        for (Produtos produto : produtos) {
            produto.setCotacao(cotacao); // insere a cotação em cada produto
        }

        // adiciona todos os produtos à lista de produtos da cotação
        cotacao.getProdutos().addAll(produtos);

        cotacaoRepository.save(cotacao);
    }

    public void inserirFornecedores(List<Fornecedores> fornecedores, Integer idProduto){
        var produto = produtosRepository.findById(idProduto).orElse(null);

        for (Fornecedores fornecedor : fornecedores) {
            fornecedor.setProduto(produto);
        }

        produto.getFornecedores().addAll(fornecedores);
        produto.getCotacao().setStatus(CotacaoStatus.PRECIFICADA);

        produtosRepository.save(produto);
    }

    public void deletarCotacao(Integer id){
        cotacaoRepository.deleteById(id);
    }

    public void deletarProdutos(Integer id){
        produtosRepository.deleteById(id);
    }

    public void deletarFornecedores(Integer id){
        fornecedoresRepository.deleteById(id);
    }

    public void atualizarFornecedor(Integer id, Fornecedores fornecedorAtualizado){
        var fornecedor = fornecedoresRepository.findById(id).orElse(null);

        fornecedor.setPreco(fornecedorAtualizado.getPreco());
        fornecedor.setNome(fornecedorAtualizado.getNome());

        fornecedoresRepository.save(fornecedor);
    }

    public Cotacao exibirCotacao(Integer id){
        var cotacao = cotacaoRepository.findById(id).orElse(null);

        return cotacao;
    }

    public List<Produtos> exibirProdutos(Integer idCotacao){
        var cotacao = cotacaoRepository.findById(idCotacao).orElse(null);

        return cotacao.getProdutos();
    }

    public List<Fornecedores> exibirFornecedores(Integer idProduto){
        var produto = produtosRepository.findById(idProduto).orElse(null);

        return produto.getFornecedores();
    }

    public List<Cotacao> exibirTodasCotacoes(){
        return cotacaoRepository.findAll();
    }
}
