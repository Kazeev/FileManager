package ru.kazeev.jaxrs.fileCRUD.dao;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "file", schema = "file_manager", catalog = "FileManager")
public class FileEntity {
    private int id;
    private String name;
    private String extension;
    private String path;
    private Date dateUpload;
    private AccountEntity accountByIdUserUpload;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "extension", nullable = false, length = 10)
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Basic
    @Column(name = "path", nullable = false, length = -1)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date_upload", nullable = false)
    public Date getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(Date dateUpload) {
        this.dateUpload = dateUpload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileEntity that = (FileEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (extension != null ? !extension.equals(that.extension) : that.extension != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (dateUpload != null ? !dateUpload.equals(that.dateUpload) : that.dateUpload != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (dateUpload != null ? dateUpload.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_user_upload", referencedColumnName = "id", nullable = false)
    public AccountEntity getAccountByIdUserUpload() {
        return accountByIdUserUpload;
    }

    public void setAccountByIdUserUpload(AccountEntity accountByIdUserUpload) {
        this.accountByIdUserUpload = accountByIdUserUpload;
    }
}
