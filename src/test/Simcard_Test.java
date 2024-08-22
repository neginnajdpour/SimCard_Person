package test;

import controller.SimcardController;
import model.da.PersonDa;
import model.entity.Operator;
import model.entity.Person;

public class Simcard_Test {
    public static void main(String[] args) {
        Person person = new Person();

        try (PersonDa personda = new PersonDa()){
            person = personda.findById(1);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        SimcardController.saveSimcard(Operator.valueOf("MCI"),"09144079809",person);





    }
}
