package org.barbecue.module.account.setvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.barbecue.module.account.dao.AccountDaoImp;
import org.barbecue.module.account.dto.AccountDto;

import java.sql.SQLException;

public class AccountCervices {
    static AccountDaoImp dao = new AccountDaoImp();

    public static String getUserById(Integer userId) throws SQLException, JsonProcessingException {
        return new ObjectMapper().writeValueAsString(dao.find(userId));
    }

    public static String getAllUser() throws SQLException, JsonProcessingException {
        return new ObjectMapper().writeValueAsString(dao.find());
    }

    public static void createUser(AccountDto account) throws SQLException {
        dao.create(account);
    }
}
