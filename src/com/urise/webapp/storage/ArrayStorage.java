package com.urise.webapp.storage;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

//    public void clear() {
//        Arrays.fill(storage, 0, size, null);
//        size = 0;
//    }

//    public void update(Resume r) {
//        int index = getIndex(r.getUuid());
//        if (index == -1) {
//            System.out.println("Resume " + r.getUuid() + " doesn't exist");
//        } else {
//            storage[index] = r;
//        }
//    }

//    public void save(Resume r) {
//        if (size >= STORAGE_LIMIT) {
//            System.out.println("Storage overflow");
//        } else if (getIndex(r.getUuid()) >= 0) {
//            System.out.println("Resume " + r.getUuid() + " already exists");
//        } else {
//            storage[size] = r;
//            size++;
//        }
//    }

//    public void delete(String uuid) {
//        int index = getIndex(uuid);
//        if (index == -1) {
//            System.out.println("Resume " + uuid + " doesn't exist");
//        } else {
//            storage[index] = storage[size - 1];
//            storage[size - 1] = null;
//            size--;
//        }
//    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
//    public Resume[] getAll() {
//        return Arrays.copyOf(storage, size);
//    }
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if ((uuid.equals(storage[i].getUuid()))) {
                return i;
            }
        }
        return -1;
    }
}
