package github.jadilson22a.APICompras.Controllers;

import github.jadilson22a.APICompras.Models.Cotacao;
import github.jadilson22a.APICompras.Models.Fornecedores;
import github.jadilson22a.APICompras.Models.Produtos;
import github.jadilson22a.APICompras.Services.CotacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    private CotacaoService service;
    public CotacaoController(CotacaoService service) {
        this.service = service;
    }


    // métodos de inserção ------------------
    @PostMapping
    public ResponseEntity inserirCotacao(@RequestBody Cotacao cotacao){
        service.inserirCotacao(cotacao);

        // Retorna POST URI: http://localhost:8080/cotacao
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("")
                        .buildAndExpand(cotacao)
                        .toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/produtos/{idCotacao}")
    public void inserirProdutos(@RequestBody List<Produtos> produtos,
                                @PathVariable Integer idCotacao){
        service.inserirItens(produtos, idCotacao);
    }

    @PostMapping("/fornecedores/{idProduto}")
    public void inserirFornecedores(@RequestBody List<Fornecedores> listaFornecedores,
                                    @PathVariable Integer idProduto){
        service.inserirFornecedores(listaFornecedores, idProduto);
    }


    // metodos de exclusão --------------------
    @DeleteMapping("/{id}")
    public void deletarCotacao(@PathVariable Integer id){
        service.deletarCotacao(id);
    }

    @DeleteMapping("/produtos/{id}")
    public void deletarProdutos(@PathVariable Integer id){
        service.deletarProdutos(id);
    }

    @DeleteMapping("/fornecedores/{id}")
    public void deletarFornecedores(@PathVariable Integer id){
        service.deletarFornecedores(id);
    }


    // metodos de atualização -----------------
    @PutMapping("/fornecedores/{id}")
    public void atualizarFornecedores(@PathVariable Integer id, @RequestBody Fornecedores fornecedorAtualizado){
        service.atualizarFornecedor(id, fornecedorAtualizado);
    }

    // metodos de consulta --------------------
    @GetMapping
    public List<Cotacao> exibirTodasCotacoes(){
        return service.exibirTodasCotacoes();
    }

    @GetMapping("/{id}")
    public Cotacao exibirCotacao(@PathVariable Integer id){
        return service.exibirCotacao(id);
    }

    @GetMapping("/produtos/{idCotacao}")
    public List<Produtos> exibirProdutos(@PathVariable Integer idCotacao){
        return service.exibirProdutos(idCotacao);
    }

    @GetMapping("/fornecedores/{idProduto}")
    public List<Fornecedores> exibirFornecedores(@PathVariable Integer idProduto){
        return service.exibirFornecedores(idProduto);
    }
}
