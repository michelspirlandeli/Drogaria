package br.com.michel.drogaria.dao;

import org.junit.Test;

import br.com.michel.drogaria.DAO.EstadoDAO;
import br.com.michel.drogaria.entity.Estado;

public class EstadoDAOTest {
	@Test
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

}
