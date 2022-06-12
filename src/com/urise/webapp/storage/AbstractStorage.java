package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractStorage implements Storage {

    public Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        boolean isExist = isExist(searchKey);
        if (!isExist) {
            throw new NotExistStorageException(uuid);
        }
        return doGet(searchKey);
    }

    public void save(Resume r) {
        Object searchKey = getSearchKey(r.getUuid());
        boolean isExist = isExist(searchKey);
        if (isExist) {
            throw new ExistStorageException(r.getUuid());
        }
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        boolean isExist = isExist(searchKey);
        if (!isExist) {
            throw new NotExistStorageException(uuid);
        }
        doDelete(searchKey);
    }

    public void update(Resume r) {
        Object searchKey = getSearchKey(r.getUuid());
        boolean isExist = isExist(searchKey);
        if (!isExist) {
            throw new NotExistStorageException(r.getUuid());
        }
        doUpdate(r, searchKey);
    }

    public abstract void clear();

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public abstract Resume[] getAll();

    public abstract int size();

    public abstract Resume doGet(Object searchKey);

    public abstract void doSave(Resume r, Object searchKey);

    public abstract void doDelete(Object searchKey);

    public abstract void doUpdate(Resume r, Object searchKey);

    protected abstract Integer getSearchKey(String uuid);

    protected abstract boolean isExist(Object searchKey);
}
