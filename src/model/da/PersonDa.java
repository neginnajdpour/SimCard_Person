package model.da;

import model.entity.Person;
import model.utils.DBConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDa implements DataAccess<Person,Integer> {


    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public PersonDa() {

    }

    @Override
    public void save(Person person) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("INSERT INTO PERSON_TBL(NAME,FAMILY) VALUES (?,?)");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.execute();
    }

    @Override
    public void edit(Person person) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("UPDATE PERSON_TBL SET NAME = ?, FAMILY = ? WHERE ID = ?");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setInt(3, person.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void remove(int Id) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("DELETE FROM PERSON_TBL WHERE ID = ?");
        preparedStatement.setInt(1, Id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void remove(Person person) throws Exception {

    }

    @Override
    public Person findById(Integer id) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON_TBL WHERE ID = ?");
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt("ID"));
            person.setName(resultSet.getString("NAME"));
            person.setFamily(resultSet.getString("FAMILY"));
            //person.setFamily(resultSet.getString("FAMILY"));
            return person;
        }
        else return null;
    }

    @Override
    public Integer findCountByPersonId(Integer personId) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM PERSON_TBL WHERE ID = ?");

        return 0;
    }

    @Override
    public List<Person>  findByFamily(String family) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON_TBL WHERE FAMILY = ?");
        preparedStatement.setString(1, family);
        resultSet = preparedStatement.executeQuery();
        List<Person> persons = new ArrayList<>();
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt("ID"));
            person.setName(resultSet.getString("NAME"));
            person.setFamily(resultSet.getString("FAMILY"));
            //person.setSimcardlist(resultSet.getInt("ID"));

            persons.add(person);
        }
        return persons;
    }


    @Override
    public List<Person> findAll() throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON_TBL");
        resultSet = preparedStatement.executeQuery();
        List<Person> persons = new ArrayList<Person>();
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt("ID"));
            person.setName(resultSet.getString("NAME"));
            person.setFamily(resultSet.getString("FAMILY"));
            //person.setSimcardlist();

            persons.add(person);
        }


        return persons;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();

    }
}
