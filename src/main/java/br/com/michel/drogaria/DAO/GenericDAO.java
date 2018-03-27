package br.com.michel.drogaria.DAO;

import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.michel.drogaria.util.HibernateUtil;

public class GenericDAO<Entity> {
	
	private Class<Entity> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	public void salvar(Entity entity) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(entity);
			transacao.commit();
		}catch (RuntimeException erro) {
			if(transacao != null) {
				transacao.rollback();
			}
			throw erro;
		}
		finally {
			sessao.close();
		}
	}

}
