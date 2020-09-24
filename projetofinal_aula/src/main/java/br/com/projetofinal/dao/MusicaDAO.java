package br.com.projetofinal.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.beans.Musica;

public interface MusicaDAO extends CrudRepository<Musica, Integer>{
	ArrayList<Musica> findByLancamento(int lancamento);
	
}
