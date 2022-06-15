package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        // TODO
        // I don't understand why an expression below is incorrect.
        // I suppose that it's due with different orders between the expected array and the current array.
        return map.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Resume doGet(Object searchKey) {
        return map.get(searchKey);
    }

    @Override
    public void doSave(Resume r, Object searchKey) {
        map.put(String.valueOf(searchKey), r);
    }

    @Override
    public void doDelete(Object searchKey) {
        map.remove(searchKey);
    }

    @Override
    public void doUpdate(Resume r, Object searchKey) {
        map.put(String.valueOf(searchKey), r);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.get(searchKey) != null;
    }
}