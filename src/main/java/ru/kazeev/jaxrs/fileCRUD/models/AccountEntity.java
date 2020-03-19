package ru.kazeev.jaxrs.fileCRUD.models;

import javax.persistence.*;

@Entity
@Table(name = "account", schema = "file_manager", catalog = "file_manager")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String pass;

    public AccountEntity() {
    }

    public AccountEntity(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        AccountEntity accountEntity = (AccountEntity) obj;

        if (id != accountEntity.id) return false;
        if (name != null ? !name.equals(accountEntity.name) : accountEntity.name != null) return false;
        if (pass != null ? !pass.equals(accountEntity.pass) : accountEntity.pass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.join(" ", String.valueOf(id), name, pass);
    }
}
