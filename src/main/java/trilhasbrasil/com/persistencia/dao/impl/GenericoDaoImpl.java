package trilhasbrasil.com.persistencia.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import trilhasbrasil.com.persistencia.dao.GenericoDao;

public abstract class GenericoDaoImpl<T> implements GenericoDao<T> {

	@PersistenceContext(unitName = "trilhasbr")
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	public T salvar(T entity) {
		if(!this.isPersistente(entity)) {
			this.getEntityManager().persist(entity);
			return entity;
		} else {
			return this.getEntityManager().merge(entity);
		}
			
	}

	public Boolean remove(T entity) {
		try {
			this.getEntityManager().remove(entity);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public Boolean remove(Long id) {
		try {
			T entity = this.procurarPeloId(id);
			return this.remove(entity);
		} catch (Exception ex) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public T procurarPeloId(Long id) {
		return (T) this.getEntityManager().find(this.getTypeClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> procurarTodos() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> cq = (CriteriaQuery<T>) cb.createQuery(this.getTypeClass());
		Root<T> pet = (Root<T>) cq.from(this.getTypeClass());
		cq.select(pet);
		TypedQuery<T> q = getEntityManager().createQuery(cq);
		return q.getResultList();
	}
	
	protected abstract Boolean isPersistente(T entity);
	
	//Method for get type class extended this class
	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
	}
	
}
