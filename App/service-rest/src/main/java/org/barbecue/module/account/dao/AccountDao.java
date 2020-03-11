package org.barbecue.module.account.dao;

import org.barbecue.module.account.dto.AccountDto;

public interface AccountDao {
    public AccountDto find(Integer id);
    public AccountDto find();
    public void create(Integer id);
    public void delete(Integer id);
    public void update(Integer id);

}
