package github.jadilson22a.APICompras.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 250)
    private String nome;

    @Column(name = "quantidade", precision = 10, scale = 0)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "cotacao_id")
    private Cotacao cotacao;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fornecedores> fornecedores;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Cotacao getCotacao() {
        return cotacao;
    }

    public void setCotacao(Cotacao cotacao) {
        this.cotacao = cotacao;
    }

    public List<Fornecedores> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedores> fornecedores) {
        this.fornecedores = fornecedores;
    }
}
