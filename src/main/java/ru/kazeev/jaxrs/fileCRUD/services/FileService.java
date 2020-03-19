package ru.kazeev.jaxrs.fileCRUD.services;


import ru.kazeev.jaxrs.fileCRUD.DAO.FileDao;
import ru.kazeev.jaxrs.fileCRUD.models.FileEntity;

import java.util.List;

public class FileService implements Service<FileEntity> {
    private FileDao fileDao = new FileDao();

    @Override
    public FileEntity getById(int id) {
        return fileDao.getById(id);
    }

    @Override
    public List<FileEntity> getAllById(int id) {
        return fileDao.getAllById(id);
    }

    @Override
    public void save(FileEntity fileEntity) {
        fileDao.save(fileEntity);
    }

    @Override
    public void update(FileEntity fileEntity) {
        fileDao.update(fileEntity);
    }

    @Override
    public void delete(FileEntity fileEntity) {
        fileDao.delete(fileEntity);
    }
}