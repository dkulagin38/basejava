package com.urise.webapp.storage;

import org.junit.Test;

public class ListStorageTest extends AbstractStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }

    @Test()
    @Override
    public void saveOverflow() {
    }
}
