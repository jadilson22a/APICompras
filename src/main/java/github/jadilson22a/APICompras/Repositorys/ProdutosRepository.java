package github.jadilson22a.APICompras.Repositorys;

import github.jadilson22a.APICompras.Models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
}
