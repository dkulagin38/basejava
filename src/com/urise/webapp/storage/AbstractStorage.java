package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractStorage implements Storage {

/*
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    // Quantity of resumes
    protected int size;
*/

/*
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }
*/

    public abstract Resume get(String uuid);

/*
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            insertElement(r, index);
            size++;
        }
    }
*/

    public abstract void save(Resume r);

/*
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }
*/

    public abstract void delete(String uuid);

/*
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[index] = r;
        }
    }
*/

    public abstract void update(Resume r);

/*
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }
*/
    public abstract void clear();

    /**
     * @return array, contains only Resumes in storage (without null)
     */
/*
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }
*/

    public abstract Resume[] getAll();

//    public int size() {
//        return size;
//    }

    public abstract int size();

    protected abstract int getIndex(String uuid);

/*
    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);
*/
}
