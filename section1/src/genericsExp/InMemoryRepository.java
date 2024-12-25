package multithreadingExp.genericsExp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T, ID> implements GenericRepository<T, ID> {
    private Map<ID, T> store = new HashMap<>();

    @Override
    public T save(T entity) {
        ID id = extractID(entity);
        store.put(id, entity);
        return entity;
    }

    private ID extractID(T entity) {
        try {
            return (ID) entity.getClass().getMethod("getId").invoke(entity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract ID from entity", e);
        }
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public T findById(ID id) {
        return store.get(id);
    }

    @Override
    public void deleteById(ID id) {
        store.remove(id);
    }
}
