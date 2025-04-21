package github.jadilson22a.APICompras.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= "cotacoes")
public class Cotacao {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id")
    private LocalDate dataCriada;

    @OneToMany(mappedBy = "cotacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produtos> produtos;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CotacaoStatus status;

    public Integer getId() {
        return id;
    }

    public LocalDate getDataCriada() {
        return dataCriada;
    }

    public void setDataCriada(LocalDate dataCriada) {
        this.dataCriada = dataCriada;
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
