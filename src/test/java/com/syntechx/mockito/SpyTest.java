package com.syntechx.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

    @Test
    public void test_UsingMockAndStub() {
        List<String> arrayListMock = mock(ArrayList.class);

        // Mocks return default value
        assertEquals(0, arrayListMock.size());

        stub(arrayListMock.size()).toReturn(5);
        arrayListMock.add("Dummy"); // This line does not matter since it's adding to a mock
        assertEquals(5, arrayListMock.size());
    }

    @Test
    public void test_UsingSpy() {
        List<String> arrayListSpy = spy(ArrayList.class);

        // Mocks return default value
        assertEquals(0, arrayListSpy.size());

        arrayListSpy.add("Dummy");
        assertEquals(1, arrayListSpy.size());
        arrayListSpy.remove("Dummy");
        assertEquals(0, arrayListSpy.size());
    }

    @Test
    public void test_UsingSpyAndVerify() {
        List<String> arrayListSpy = spy(ArrayList.class);

        arrayListSpy.add("Dummy");
        verify(arrayListSpy).add("Dummy");
    }
}
