package multithreadingExp.genericsExp;

import java.util.List;

public interface GenericRepository<T, ID> {
    T save(T entity);

    List<T> findAll();

    T findById(ID id);

    void deleteById(ID id);
}
