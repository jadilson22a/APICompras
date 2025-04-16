package github.jadilson22a.APICompras.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "produtos")
@Data
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

}
