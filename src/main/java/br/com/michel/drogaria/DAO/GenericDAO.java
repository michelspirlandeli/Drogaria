package br.com.michel.drogaria.DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	
	@SuppressWarnings("unchecked")
	public List<Entity> listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entity> resultado = consulta.list();
			return resultado;
		}catch (RuntimeException erro) {
			// TODO: handle exception
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entity buscar(Long codigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entity resultado = (Entity) consulta.uniqueResult();
			return resultado;
		}catch (RuntimeException erro) {
			// TODO: handle exception
			throw erro;
		}finally {
			sessao.close();
		}
	}

}
