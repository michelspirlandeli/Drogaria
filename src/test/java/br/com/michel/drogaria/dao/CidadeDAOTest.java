package br.com.michel.drogaria.dao;

import org.junit.Test;

import br.com.michel.drogaria.DAO.CidadeDAO;
import br.com.michel.drogaria.DAO.EstadoDAO;
import br.com.michel.drogaria.entity.Cidade;
import br.com.michel.drogaria.entity.Estado;

public class CidadeDAOTest {
	@Test
	public void salvar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		
		Estado estado = estadoDAO.buscar(1L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("santa catarina");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
}
