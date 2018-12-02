package com.succApplication.repositories;

import com.succApplication.connectionPool.MysqlConnectionPool;
import com.succApplication.entities.Sucker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MySqlSuccRepository implements SuccRepository{

    public MySqlSuccRepository(){
        establishDriver();
    }

    private final static String URL = "jdbc:sqlite:C:/sqlite/succDB.db";
    private final static String SELECT_BY_NAME = "select name, isSucc from succ where name = ?";
    private final static String INSERT_NEW =
            "     INSERT INTO succ (" +
            "                     name," +
            "                     isSucc" +
            "                 )" +
            "                 VALUES (" +
            "                     ?," +
            "                     ?" +
            "                 );";


    public Optional<Sucker> findByName(String name){
        try (Connection conn = MysqlConnectionPool.getPool().getConnection()){
            conn.setAutoCommit(false);
            System.out.println("Connected to SQLite, going to Select");

            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isClosed()){
                return Optional.of(new Sucker(resultSet.getString("NAME"),
                        resultSet.getBoolean("isSucc")));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void saveNewSucc(Sucker sucker){
        try (Connection conn = MysqlConnectionPool.getPool().getConnection()) {
            conn.setAutoCommit(false);
            System.out.println("Connected to SQLite, going to Insert");

            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, sucker.getName());
            preparedStatement.setBoolean(2, sucker.getSucc());
            preparedStatement.execute();
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void establishDriver(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
}
