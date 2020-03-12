package org.barbecue.module.account.dao;

import org.barbecue.module.account.AccountDataBaceConnector;
import org.barbecue.module.account.dto.AccountDto;

import java.sql.SQLException;

public interface AccountDao {

    public AccountDto find(Integer id) throws SQLException;
    public AccountDto find();
    public void create(AccountDto accountDto) throws SQLException;
    public void delete(AccountDto accountDto) throws SQLException;
    public void update(Integer id);

}
