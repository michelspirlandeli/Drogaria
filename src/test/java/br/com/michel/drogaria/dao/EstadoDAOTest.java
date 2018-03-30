package br.com.michel.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.michel.drogaria.DAO.EstadoDAO;
import br.com.michel.drogaria.entity.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore//não quero que o salvar rode
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		for(Estado estado : resultado) {
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	public void buscar() {
		Long codigo = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if(estado == null) {
			System.out.println("Nenhum encontrado");
		}else {
			System.out.println("Registro encontrdo");
		System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}

	}

}
