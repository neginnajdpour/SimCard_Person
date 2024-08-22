package test;

import model.da.PersonDa;
import model.da.SimcardDa;
import model.entity.Operator;
import model.entity.Person;
import model.entity.Simcard;

public class Simcard_Test {
    public static void main(String[] args) {
        Person person = new Person();

        try (PersonDa personda = new PersonDa()){
            person = personda.findById(1);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Simcard simcard = new Simcard();
        simcard.setOperator(Operator.MCI);
        simcard.setNumber("09143177740");
        simcard.setOwner(person);

        try (SimcardDa simcardda = new SimcardDa()){
            simcardda.save(simcard);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }





    }
}
