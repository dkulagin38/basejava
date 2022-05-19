import sun.security.util.ArrayUtil;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid.equals(uuid)) return storage[i];
            } else {
                break;
            }
        }
        return null;
    }

    void delete(String uuid) {
        Resume[] tempStorage = new Resume[storage.length];
        int tempLength = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (!storage[i].uuid.equals(uuid)) {
                    tempStorage[tempLength++] = storage[i];
                }
            } else break;
        }
        storage = Arrays.copyOf(tempStorage, tempStorage.length);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        /*
        * The 'Arrays.copyOf' method was recommended in the webinar 'StartJava'.
        * I didn't use that method because in this case I have to know a size of the non-null array.
        */
        return Arrays.stream(storage).filter(s -> (s != null)).toArray(Resume[]::new);
    }

    int size() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                count++;
            } else break;
        }
        return count;
    }
}
