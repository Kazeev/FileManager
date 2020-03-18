package org.barbecue.module.account.dao;

import org.barbecue.module.account.dto.AccountDto;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    static final String URL ="jdbc:postgresql://localhost:5432/FileManager";
    static final String LOGIN ="postgres";
    static final String PASS ="admin";

    public AccountDto find(Integer id) throws SQLException;
    public List<?> find() throws SQLException;
    public void create(AccountDto accountDto) throws SQLException;
    public void delete(AccountDto accountDto) throws SQLException;
    public void update(Integer id);

}
