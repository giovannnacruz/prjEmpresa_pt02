package com.Giovanna.PrjEmpresa.controllers;

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

import com.Giovanna.PrjEmpresa.Service.DepartamentoService;
import com.Giovanna.PrjEmpresa.Service.FuncionarioService;
import com.Giovanna.PrjEmpresa.entities.Departamento;
import com.Giovanna.PrjEmpresa.entities.Funcionario;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> findFuncionariobyId(@PathVariable Long id) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(id);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/nome/{funnome}")
	public ResponseEntity<List<Funcionario>> findFuncionariosByNomeAproximado(@PathVariable String funnome) {
	    List<Funcionario> funcionarios = funcionarioService.getFuncionariosByFunnomeAproximado(funnome);
	    if (!funcionarios.isEmpty()) {
	        return ResponseEntity.ok(funcionarios);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	

	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> findAllUsuarioscontrol() {
		List<Funcionario> funcionario = funcionarioService.getAllFuncionarios();
		return ResponseEntity.ok(funcionario);
	}

	@PostMapping("/")
	public ResponseEntity<Funcionario> insertUsuariosControl(@RequestBody Funcionario funcionario) {
		Funcionario novofuncionario = funcionarioService.saveFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novofuncionario);
	}

	@PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long funcodigo, @RequestBody Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioService.updateFuncionario(funcodigo, funcionario);
        if (funcionarioAtualizado != null) {
            return ResponseEntity.ok(funcionarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@DeleteMapping("/id")
	public ResponseEntity<String> deleteUsuarioControl(@PathVariable Long funcodigo) {
		boolean remover = funcionarioService.deleteFuncionario(funcodigo);
		if (remover) {
			return ResponseEntity.ok().body("usuario Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}