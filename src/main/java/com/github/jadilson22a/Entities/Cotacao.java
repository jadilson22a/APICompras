package com.github.jadilson22a.Entities;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cotacoes")
public class Cotacao {
	
	@Id
	private String id;
	private List<Integer> requisicoes;
	private boolean concluido = false;
	private Tipo tipo;
	private List<Orcamento> orcamentos;
	private Integer pedido;
	
	public Cotacao() {
	}

	public Cotacao(String id, List<Integer> requisicoes, Tipo tipo, List<Orcamento> orcamentos) {
		this.id = id;
		this.requisicoes = requisicoes;
		this.tipo = tipo;
		this.orcamentos = orcamentos;
	}
	
	

	public Cotacao(List<Integer> requisicoes, Tipo tipo, List<Orcamento> orcamentos) {
		this.requisicoes = requisicoes;
		this.tipo = tipo;
		this.orcamentos = orcamentos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Integer> getRequisicoes() {
		return requisicoes;
	}

	public void setRequisicoes(List<Integer> requisicoes) {
		this.requisicoes = requisicoes;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public boolean isConcluido() {
		return concluido;
	}
	
	public Integer getPedido() {
		return pedido;
	}

	public void concluir(Integer pedido) {
		this.pedido = pedido;
		this.concluido = true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(concluido, id, orcamentos, pedido, requisicoes, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cotacao other = (Cotacao) obj;
		return concluido == other.concluido && Objects.equals(id, other.id)
				&& Objects.equals(orcamentos, other.orcamentos) && Objects.equals(pedido, other.pedido)
				&& Objects.equals(requisicoes, other.requisicoes) && tipo == other.tipo;
	}

}
