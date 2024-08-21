package test;

import javafx.scene.control.Alert;
import model.da.PersonDa;
import model.entity.Person;

public class test {
    public static void main(String[] args) {
//        Person person = new Person();
//        person.setId(1);
//        person.setName("negin");
//        person.setFamily("najdpour");

        try (PersonDa personDa = new PersonDa()) {
            System.out.println(personDa.findByFamily("najdpourrr"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
