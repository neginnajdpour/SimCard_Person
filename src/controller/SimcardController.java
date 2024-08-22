package controller;

import javafx.fxml.Initializable;
import model.da.SimcardDa;
import model.entity.Operator;
import model.entity.Person;
import model.entity.Simcard;

import java.net.URL;
import java.util.ResourceBundle;

public class SimcardController implements Initializable {

    public static void saveSimcard(Operator operator,String Number , Person person) {

        Simcard simcard = new Simcard();
        simcard.setOperator(operator);
        simcard.setNumber(Number);
        try (SimcardDa simcardDa = new SimcardDa()){
            simcardDa.save(simcard);
            System.out.println("simcard saved !");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
