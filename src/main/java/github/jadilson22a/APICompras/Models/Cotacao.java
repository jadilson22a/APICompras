package github.jadilson22a.APICompras.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "cotacoes")
public class Cotacao {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "cotacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produtos> produtos;

    @Column(name = "status")
    private CotacaoStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    public CotacaoStatus getStatus() {
        return status;
    }

    public void setStatus(CotacaoStatus status) {
        this.status = status;
    }
}
