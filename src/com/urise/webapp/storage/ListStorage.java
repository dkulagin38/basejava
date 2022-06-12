package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> list = new ArrayList<>();

    @Override
    public Resume doGet(Object searchKey) {
        return list.get((Integer) searchKey);
    }

    @Override
    public void doSave(Resume r, Object searchKey) {
        list.add(r);
    }

    @Override
    public void doDelete(Object searchKey) {
        list.remove(((Integer) searchKey).intValue());
    }

    @Override
    public void doUpdate(Resume r, Object searchKey) {
        list.set((Integer) searchKey, r);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
//        Intellij warned about the commented expression, so I've changed that one.
//        return list.toArray(new Resume[list.size()]);
        return list.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (uuid.equals(list.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }
}
