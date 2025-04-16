package Practice.jdbc;

import java.util.Collection;

public interface StudentInterfaceDao <T ,K>{
Collection<T> getAll();
	
	T getOne(K Key);
	void add(T t);
	void Update( T t);
	void Delete(K Key);

}
