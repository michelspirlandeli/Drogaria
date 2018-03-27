package br.com.michel.drogaria.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

 
@SuppressWarnings("serial")//para ele iginorar o warning do tipo serial
@MappedSuperclass //ela não corresponde a uma tabela mais vai ser utilizado por outros
public class GenericDomain implements Serializable {
	
	//seriazable serializar um objeto significa transformá-lo em um stream de bytes que pode ser gravado ou transmitido. Usa-se serialização quando se quer gravar objetos em arquivos ou transmití-los pela rede.Em projetos você pode serializar os beans e os managed beans caso esteja usando JSF
	
	@Id //ele e uma chave primaria
	@GeneratedValue(strategy = GenerationType.AUTO) //pode ter propiedades
	private Long codigo;
	
	//get permissao leitura
	
	//set permissao de escrita
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
