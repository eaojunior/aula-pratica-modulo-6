package br.com.aula.atividade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.atividade.entity.Aula;
import br.com.aula.atividade.service.AulaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/aulas")
public class AulaController {
	@Autowired
	AulaService aulaService;
	
	@GetMapping
	@Operation(summary="Listar todas as aulas", description  = "Listagem de Aulas")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
	public ResponseEntity<List<Aula>> getAll(){
		List<Aula> aulas = aulaService.getAll();
		if(!aulas.isEmpty())
			return new ResponseEntity<>(aulas, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aula> getById(@PathVariable Integer id) {
		Aula aula = aulaService.getById(id);
		if(aula != null)
			return new ResponseEntity<>(aula, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}
	
	@PostMapping
	public ResponseEntity<Aula> saveAula(@RequestBody Aula aula) {
		return new ResponseEntity<>(aulaService.saveAula(aula), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aula> updateAula(@PathVariable Integer id, @RequestBody Aula aula) {
		Aula aulaAtualizada = aulaService.updateAula(id, aula);
		if(aulaAtualizada != null)
			return new ResponseEntity<>(aulaAtualizada, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteAula(@PathVariable Integer id) {
		if(aulaService.deleteAula(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}
}
