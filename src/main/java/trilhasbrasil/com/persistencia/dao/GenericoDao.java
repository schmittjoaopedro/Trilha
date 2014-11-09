package trilhasbrasil.com.persistencia.dao;

import java.util.List;

public interface GenericoDao<T> {

	public T save(T entity);
	
	public Boolean remove(T entity);
	
	public List<T> findAll();
	
	public List<T> findByQueryAndPaginate(Integer start, Integer limit, String query);
	
}
