package com.github.jadilson22a.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jadilson22a.Dtos.CotacaoMinDTO;
import com.github.jadilson22a.Services.CotacaoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

	@Autowired
	private CotacaoService service;
	
	@PostMapping
	public ResponseEntity<Object> criar(@RequestBody CotacaoMinDTO dto){
		try {
			service.criar(dto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Object> deletar(@PathParam(value = "id") String id){
		try {
			service.deletar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNPROCESSABLE_CONTENT);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> atualizar(
			@PathParam(value = "id") String id,
			@RequestBody CotacaoMinDTO dto){
		try {
			service.atualizar(id, dto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/id")
	public ResponseEntity<Object> buscarId(@PathParam(value = "id") String id){
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/tudo")
	public ResponseEntity<Object> buscarTudo(){
		try {
			return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/requisicoes")
	public ResponseEntity<Object> buscarRcs(@RequestBody List<Integer> requisicoes){
		try {
			return new ResponseEntity<>(service.findByRequisicao(requisicoes), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/estado")
	public ResponseEntity<Object> buscarRcs(@PathParam(value = "concluido") boolean concluido){
		try {
			return new ResponseEntity<>(service.findByEstado(concluido), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
