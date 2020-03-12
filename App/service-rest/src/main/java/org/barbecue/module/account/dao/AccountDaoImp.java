package org.barbecue.module.account.dao;

import org.barbecue.module.account.dto.AccountDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImp implements AccountDao {
    static Connection connection;

    public AccountDaoImp() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AccountDto find(Integer id) throws SQLException {
        String  sql = "" +
            "select *" +
            "from file_manager.account " +
            "where id = "+ id +";";

        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        resultSet.next();
        return new AccountDto(
                resultSet.getInt( "id" )
                ,resultSet.getString( "user_name" )
                ,resultSet.getString( "pass" ));
    }

    @Override
    public List<?> find() throws SQLException {
        String  sql = "" +
            "select *" +
            "from file_manager.account";
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        List<AccountDto> accounts = new ArrayList();

        while (resultSet.next()){
            accounts.add(new AccountDto(
                     resultSet.getInt( "id" )
                    ,resultSet.getString( "user_name" )
                    ,resultSet.getString( "pass" )));
        }

        return accounts;
    }

    @Override
    public void create(AccountDto accountDto) throws SQLException {
        String  sql = "insert into file_manager.account (user_name, pass) values ( '"+accountDto.getName()+"', '"+accountDto.getPass()+"');";
        connection.createStatement().execute(sql);
    }

    @Override
    public void delete(AccountDto accountDto) throws SQLException {
        String  sql = "select *";
        connection.createStatement().execute(sql);
    }

    @Override
    public void update(Integer id) {

    }
}
