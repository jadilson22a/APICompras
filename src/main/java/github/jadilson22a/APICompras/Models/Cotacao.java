package github.jadilson22a.APICompras.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name= "cotacoes")
@Data
public class Cotacao {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "cotacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produtos> produtos;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CotacaoStatus status;
    
}
