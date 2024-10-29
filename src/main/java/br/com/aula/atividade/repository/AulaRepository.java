package br.com.aula.atividade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aula.atividade.entity.Aula;

public interface AulaRepository extends JpaRepository<Aula,Integer> {

}
