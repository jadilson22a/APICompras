package com.github.jadilson22a.Dtos;

import java.util.List;

import com.github.jadilson22a.Entities.Cotacao;
import com.github.jadilson22a.Entities.Orcamento;
import com.github.jadilson22a.Entities.Tipo;

public record CotacaoMinDTO(List<Integer> requisicoes, Tipo tipo, List<Orcamento> orcamentos) {

	public Cotacao toCotacao() {
		return new Cotacao(requisicoes, tipo, orcamentos);
	}
}
