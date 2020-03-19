package ru.kazeev.jaxrs.fileCRUD.services;


import ru.kazeev.jaxrs.fileCRUD.DAO.AccountDao;
import ru.kazeev.jaxrs.fileCRUD.models.AccountEntity;

import java.util.List;

public class AccountService implements Service<AccountEntity> {
    private AccountDao accountDao = new AccountDao();

    @Override
    public AccountEntity getById(int id) {
        return accountDao.getById(id);
    }

    @Override
    public List<AccountEntity> getAllById(int id) {
        return accountDao.getAllById(id);
    }

    @Override
    public void save(AccountEntity accountEntity) {
        accountDao.save(accountEntity);
    }

    @Override
    public void update(AccountEntity accountEntity) {
        accountDao.update(accountEntity);
    }

    @Override
    public void delete(AccountEntity accountEntity) {
        accountDao.delete(accountEntity);
    }
}
