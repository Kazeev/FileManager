package org.barbecue.module.account.dao;

import org.barbecue.module.account.AccountDataBaceConnector;
import org.barbecue.module.account.dto.AccountDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImp implements AccountDao {
    AccountDataBaceConnector accountDataBaceConnector;

    @Override
    public AccountDto find(Integer id) throws SQLException {
        String  sql = "select *";
        ResultSet resultSet = accountDataBaceConnector.getExecuteQuery( sql);
        resultSet.next();

        return new AccountDto(
                resultSet.getInt( "id" )
                ,resultSet.getString( "name" )
                ,resultSet.getString( "password" ));
    }

    @Override
    public AccountDto find() {
        return null;
    }

    @Override
    public void create(AccountDto accountDto) throws SQLException {
        String  sql = "select *";
        accountDataBaceConnector.getConnection().createStatement().execute(sql);
    }

    @Override
    public void delete(AccountDto accountDto) throws SQLException {
        String  sql = "select *";
        accountDataBaceConnector.getConnection().createStatement().execute(sql);
    }

    @Override
    public void update(Integer id) {

    }
}
