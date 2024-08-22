package model.da;

import model.entity.Person;

import java.util.List;

public interface DataAccess<T,I> extends AutoCloseable {
    void save(T t) throws Exception;
    void edit(T t) throws Exception;
    void remove(int Id) throws Exception;

    T findById(I id) throws Exception;

    Integer findCountByPersonId(Integer personId) throws Exception;

    List<Person> findByFamily(String family) throws Exception;

    List<T> findAll() throws Exception;
}
