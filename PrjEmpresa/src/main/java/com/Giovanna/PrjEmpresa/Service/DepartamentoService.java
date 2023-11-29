package com.Giovanna.PrjEmpresa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giovanna.PrjEmpresa.Repositories.DepartamentoRepository;
import com.Giovanna.PrjEmpresa.entities.Departamento;

@Service
public class DepartamentoService {

private final DepartamentoRepository departamentoRepository;
	
	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository =departamentoRepository;
	}
	//preparando as buscas por id
		public Departamento getDepartamentoById(Long depcodigo) {
			return departamentoRepository.findById(depcodigo).orElse(null);
		}
		//preparando a busca geral	
		public  List<Departamento> getAllDepartamentos(){
			return departamentoRepository.findAll();
		}
		//salvando o Jogo	
		public Departamento saveDepartamento(Departamento departamento) {
			return departamentoRepository.save(departamento);		
		}
		//excluindo o Jogo	
		public void deleteDepartamento(Long depcodigo){
			departamentoRepository.deleteById(depcodigo);	
		}	

}
