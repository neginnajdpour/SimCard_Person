package controller;

import javafx.fxml.Initializable;
import model.da.PersonDa;
import model.entity.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonController implements Initializable {

    public static void savePerson(String Name, String Family) {

        Person person = new Person();
        person.setName(Name);
        person.setFamily(Family);
        try (PersonDa personDa = new PersonDa()){
            personDa.save(person);
            System.out.println("person saved !");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
