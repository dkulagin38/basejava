package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {

    Resume get(String uuid);

    void save(Resume r);

    void delete(String uuid);

    void update(Resume r);

    void clear();

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll();

    int size();
}
