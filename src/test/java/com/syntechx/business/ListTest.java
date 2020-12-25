package com.syntechx.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {
    
    @Test
    public void testListSizeMock() {
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    @Test
    public void testListSizeMock_ReturnMultipleValues() {
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void testListGetMock() {
        List listMock = mock(List.class);

        // Argument Matcher (anyInt())
        when(listMock.get(anyInt())).thenReturn("syntechx");
        assertEquals("syntechx", listMock.get(0));
    }

    @Test
    public void testListGetMock_UsingBDD() {
        // Given
        List<String> listMock = mock(List.class);

        given(listMock.get(anyInt())).willReturn("syntechx");

        // When
        String firstElement = listMock.get(0);

        // Then
        assertThat(firstElement, is("syntechx"));
    }

    @Test(expected = RuntimeException.class)
    public void testListGetMock_ThrowAnException() {
        List listMock = mock(List.class);

        // Argument Matcher (anyInt())
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));

        listMock.get(0);
    }

    @Test(expected = RuntimeException.class)
    public void testListGetMock_MixingUp() {
        List listMock = mock(List.class);

        // Argument Matcher (anyInt())
        when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));

        listMock.get(0);
    }
}
