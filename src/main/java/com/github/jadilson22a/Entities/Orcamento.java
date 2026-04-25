package com.github.jadilson22a.Entities;

import java.util.List;
import java.util.Objects;

public class Orcamento {
	
	private String nome;
	private Integer prazo;
	private String pagamento;
	private Incoterms incoterms;
	private List<Sku> itens;
	private Double valorTotal = somaValoresSku();
	
	public Orcamento() {
		super();
	}

	public Orcamento(String nome, Integer prazo, String pagamento, Incoterms incoterms, List<Sku> itens) {
		super();
		this.nome = nome;
		this.prazo = prazo;
		this.pagamento = pagamento;
		this.incoterms = incoterms;
		this.itens = itens;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPrazo() {
		return prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public Incoterms getIncoterms() {
		return incoterms;
	}

	public void setIncoterms(Incoterms incoterms) {
		this.incoterms = incoterms;
	}

	public List<Sku> getItens() {
		return itens;
	}

	public void setItens(List<Sku> itens) {
		this.itens = itens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	private Double somaValoresSku() {
		Double valor = 0.0;
		
		for(Sku x: this.itens) {
			valor = valor + x.getValor();
		}
		
		return valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(incoterms, itens, nome, pagamento, prazo, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		return incoterms == other.incoterms && Objects.equals(itens, other.itens) && Objects.equals(nome, other.nome)
				&& Objects.equals(pagamento, other.pagamento) && Objects.equals(prazo, other.prazo)
				&& Objects.equals(valorTotal, other.valorTotal);
	}

	
}
