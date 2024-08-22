package model.da;

import model.entity.Operator;
import model.entity.Person;
import model.entity.Simcard;
import model.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimcardDa implements DataAccess <Simcard,Integer> {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public SimcardDa() {

    }

    @Override
    public void save(Simcard simcard) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("INSERT INTO SIMCARD_TBL(SIM_OPERATOR,SIM_NUMBER,OWNER_ID) VALUES (?,?,?)");
        preparedStatement.setString(1, simcard.getOperator().name());
        preparedStatement.setString(2, simcard.getNumber());
        preparedStatement.setInt(3, simcard.getOwner().getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void edit(Simcard simcard) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("UPDATE SIMCARD_TBL SET OPERATOR = ? , SIM_NUMBER = ? , OWNER_ID = ?  WHERE ID = ?");
        preparedStatement.setString(1, String.valueOf(simcard.getOperator()));
        preparedStatement.setString(2, simcard.getNumber());
        preparedStatement.setInt(3, simcard.getOwner().getId());
        preparedStatement.setInt(4, simcard.getId());
        preparedStatement.executeUpdate();

    }

    @Override
    public void remove(int Id) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("DELETE FROM SIMCARD_TBL WHERE ID = ?");
        preparedStatement.setInt(1, Id);
        preparedStatement.executeUpdate();

    }

    @Override
    public Simcard findById(Integer id) throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM SIMCARD_TBL WHERE ID = ?");
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Simcard simcard = new Simcard();
            simcard.setId(resultSet.getInt("ID"));
            simcard.setOperator(Operator.valueOf(resultSet.getString("SIM_OPERATOR")));
            simcard.setNumber(resultSet.getString("SIM_NUMBER"));
            return simcard;
        }
        else
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
    public List<Simcard> findAll() throws Exception {
        connection = DBConnection.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM SIMCARD_TBL");
        resultSet = preparedStatement.executeQuery();
        List<Simcard> simcards = new ArrayList<>();
        while (resultSet.next()) {
            Simcard simcard = new Simcard();
            simcard.setId(resultSet.getInt("ID"));
            simcard.setOperator(Operator.valueOf(resultSet.getString("SIM_OPERATOR")));
            simcard.setNumber(resultSet.getString("SIM_NUMBER"));
            simcards.add(simcard);
            simcards.add(simcard);
        }

        return simcards;
    }

    @Override
    public void close() throws Exception {

    }
}
