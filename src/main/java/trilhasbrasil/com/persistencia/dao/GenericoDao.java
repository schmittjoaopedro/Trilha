package trilhasbrasil.com.persistencia.dao;

import java.util.List;

public interface GenericoDao<T> {

	public T salvar(T entity);
	
	public Boolean remove(T entity);
	
	public Boolean remove(Long id);
	
	public List<T> procurarTodos();
	
	public T procurarPeloId(Long id);
	
	public List<T> procurarPorQueryPaginado(Integer start, Integer limit, String query);
	
}
