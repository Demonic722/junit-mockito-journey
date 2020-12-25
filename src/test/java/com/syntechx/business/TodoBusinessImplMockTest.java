package com.syntechx.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.syntechx.data.api.TodoService;

import org.junit.Test;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingAMock() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList(
            "Learn Spring MVC",
            "Learn Spring",
            "Learn to Dance"
        );
        
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_WithEmptyList() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Collections.emptyList();
        
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(0, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingBDD() {
        // Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList(
            "Learn Spring MVC",
            "Learn Spring",
            "Learn to Dance"
        );
        
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        // Then
        assertThat(filteredTodos.size(), is(2));
    }
}
