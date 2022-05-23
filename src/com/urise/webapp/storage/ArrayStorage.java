package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    // Quantity of resumes
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        if (indexOfResumeByUuid(r.getUuid()) >= 0) {
            // Actually I didn't understand from the task what I have to do in this method.
        } else {
            System.out.println("Невозможно обновить резюме " + r + ", т.к. у него не найден uuid.");
        }
    }

    public void save(Resume r) {
        if (indexOfResumeByUuid(r.getUuid()) < 0) {
            if (size < 1000) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Невозможно добавить резюме " + r + ", т.к. хранилище переполнено.");
            }
        } else {
            System.out.println("Невозможно добавить резюме " + r + ", т.к. уже существует резюме с таким uuid.");
        }
    }

    public Resume get(String uuid) {
        int index = indexOfResumeByUuid(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("Не найдено резюме с uuid " + uuid);
            return null;
        }
    }

    public void delete(String uuid) {
        int index = indexOfResumeByUuid(uuid);
        if (index >= 0) {
            /* So far, I've commented the code from the webinar because in this case
            *  the last value from the array moves to somewhere in the middle of that array.
            */
            // storage[i] = storage[size - 1];
            // storage[size - 1] = null;
            System.arraycopy(storage, index + 1, storage, index, size - index);
            size--;
        } else {
            System.out.println("Невозможно удалить резюме с uuid " + uuid + ", т.к. такой uuid не существует.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int indexOfResumeByUuid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
