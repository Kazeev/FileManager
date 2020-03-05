package ru.kazeev.jaxrs.fileCRUD.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<FileEntity> filesList = new ArrayList<>();
    private List<AccountEntity> usersList = new ArrayList<>();

    public List<FileEntity> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<FileEntity> filesList) {
        this.filesList = filesList;
    }

    public List<AccountEntity> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<AccountEntity> usersList) {
        this.usersList = usersList;
    }

    public DataBase() {

        usersList.add(new AccountEntity(0, "Name", "123"));
        usersList.add(new AccountEntity(1, "Name2", "123"));

        filesList.add(new FileEntity(0, "file", ".txt", "/main", new Date(1241421), usersList.get(0)));
        filesList.add(new FileEntity(1, "file2", ".txt", "/main/src", new Date(12414214), usersList.get(1)));
    }
}
