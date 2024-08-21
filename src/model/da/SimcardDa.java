package model.da;

import model.entity.Person;

import java.util.Collections;
import java.util.List;

public class SimcardDa implements DataAccess<Person,Integer> {
    @Override
    public void save(Person person) throws Exception {

    }

    @Override
    public void edit(Person person) throws Exception {

    }

    @Override
    public void remove(int Id) throws Exception {

    }

    @Override
    public void remove(Person person) throws Exception {

    }

    @Override
    public Person findById(Integer id) throws Exception {
        return null;
    }



    @Override
    public Integer findCountByPersonId(Integer personId) throws Exception {
        return 0;
    }

    @Override
    public List<Person> findByFamily(String family) throws Exception {
        return Collections.emptyList();
    }


    @Override
    public List<Person> findAll() throws Exception {
        return Collections.emptyList();
    }

    @Override
    public void close() throws Exception {

    }
}
