package br.com.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.beans.Musica;
import br.com.projetofinal.dao.MusicaDAO;

@CrossOrigin("*")
@RestController
public class MusicaController {

	@Autowired
	private MusicaDAO dao;
	
	@PostMapping("/alterarLancamento")
	public ResponseEntity<Musica> login(@RequestBody Musica dados){
		try {
			dao.save(dados);
			return ResponseEntity.ok(dados);
		} catch (Exception e) {
			return ResponseEntity.status(500).build();		
		}
	}
	
	@PostMapping("/gravarmusica")
	public ResponseEntity<Musica> gravarMusica(@RequestBody Musica dados){
		try {
			dao.save(dados);
			return ResponseEntity.ok(dados);
		} catch (Exception e) {
			return ResponseEntity.status(500).build();		
		}
	}
	
	@GetMapping("/musica/{id}")
	public ResponseEntity<Musica> getMusica(@PathVariable int id){
		Musica u = dao.findById(id).orElse(null);
		if(u==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(u);
	}
	@GetMapping("/musicas")
	public ResponseEntity<ArrayList<Musica>> getAll(){
		ArrayList<Musica> u = (ArrayList<Musica>)dao.findAll();
		if(u.size()==0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(u);
	}

	@GetMapping("/lancamentos/{id}")
	public ResponseEntity<ArrayList<Musica>> getLancamentos(@PathVariable int id){
		ArrayList<Musica> u = (ArrayList<Musica>)dao.findByLancamento(id);
		if(u.size()==0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(u);
	}
}
