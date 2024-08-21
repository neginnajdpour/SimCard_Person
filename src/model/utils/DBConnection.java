package model.utils;

import lombok.Getter;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    //Singleton
    @Getter
    private static DBConnection dbConnection = new DBConnection();

    private BasicDataSource basicDataSource;

    private DBConnection() {

    }

    public static DBConnection getInstance() {
        return dbConnection;
    }

    public Connection getConnection() throws SQLException {
        System.out.println("Connecting to database...");
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/mft");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("Negin@09143148516");
        basicDataSource.setInitialSize(5);
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(10);
        System.out.println("Connected to database...");
        return basicDataSource.getConnection();
    }
}
