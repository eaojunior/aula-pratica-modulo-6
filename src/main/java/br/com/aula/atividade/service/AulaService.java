package br.com.aula.atividade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aula.atividade.entity.Aula;
import br.com.aula.atividade.repository.AulaRepository;

@Service
public class AulaService {
	@Autowired
	AulaRepository aulaRepository;
	
	public List<Aula> getAll(){
		return aulaRepository.findAll();
	}
	
	public Aula getById(Integer id) {
		return aulaRepository.findById(id).orElse(null) ;
	}
	
	public Aula saveAula(Aula aula) {
		return aulaRepository.save(aula);
	}
	
	public Aula updateAula(Integer id, Aula aula) {
		Aula aulaParaAtualizar = aulaRepository.findById(id).orElse(null);
		if(aulaParaAtualizar != null) {
			aulaParaAtualizar.setNome(aula.getNome());
			return aulaRepository.save(aulaParaAtualizar);
		}else {
			return null;
		}
	}

	public Boolean deleteAula(Integer id) {
		Aula aula = aulaRepository.findById(id).orElse(null);
		if(aula != null) {
			aulaRepository.delete(aula);
			return true;
		}else {
			return false;
		}
	}
}
