package br.com.michel.drogaria.dao;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.michel.drogaria.DAO.FabricanteDAO;
import br.com.michel.drogaria.DAO.ProdutoDAO;
import br.com.michel.drogaria.entity.Fabricante;
import br.com.michel.drogaria.entity.Produto;

public class produtoDAOTest {
	
	@Test
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("3"));
		Produto produto = new Produto();
		produto.setDescricao("Cataflan 50mg com 20 Comprimidos");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
		System.out.println("Produto salvo com sucesso");
	}

}
