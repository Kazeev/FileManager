package ru.kazeev.jaxrs.fileCRUD.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "file", schema = "file_manager", catalog = "file_manager")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String extension;
    private String path;
    @Column (name = "date_upload")
    private Date dateUpload;
    private AccountEntity accountByIdUserUpload;

    public FileEntity() {
    }

    public FileEntity(String name, String extension, String path, Date dateUpload, AccountEntity accountByIdUserUpload) {
        this.name = name;
        this.extension = extension;
        this.path = path;
        this.dateUpload = dateUpload;
        this.accountByIdUserUpload = accountByIdUserUpload;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(Date dateUpload) {
        this.dateUpload = dateUpload;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        FileEntity fileEntity = (FileEntity) obj;

        if (id != fileEntity.id) return false;
        if (name != null ? !name.equals(fileEntity.name) : fileEntity.name != null) return false;
        if (extension != null ? !extension.equals(fileEntity.extension) : fileEntity.extension != null) return false;
        if (path != null ? !path.equals(fileEntity.path) : fileEntity.path != null) return false;
        if (dateUpload != null ? !dateUpload.equals(fileEntity.dateUpload) : fileEntity.dateUpload != null) return false;

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

    @Override
    public String toString() {
        return String.join(" ", String.valueOf(id), name, extension, path, dateUpload.toString(), accountByIdUserUpload.toString());
    }
}
