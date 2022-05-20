import sun.security.util.ArrayUtil;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    // Quantity of resumes
    int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        // I suppose the 'uuid' is an unique value. So the number of removing elements are always equal 1.
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                // The case if all elements were removed. All elements equal null. 1 is a quantity of removed elements.
                if (size == 1) return;
                break;
            }
        }

        /* Move a removed value to the end of an actual array.
         * The used method is similar to a bubble sort.
         */
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (storage[j] == null) {
                    storage[j] = storage[j + 1];
                    storage[j + 1] = null;
                }
            }
        }
        size--;
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
        return size;
    }
}
