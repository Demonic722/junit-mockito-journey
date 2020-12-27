package com.syntechx.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.syntechx.data.api.TodoService;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TodoBusinessImplMockitoInjectMockTest {
    
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private TodoService todoServiceMock;

    @InjectMocks
    private TodoBusinessImpl todoBusinessImpl;

    @Captor
    private ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingAMock() {
        List<String> todos = Arrays.asList(
            "Learn Spring MVC",
            "Learn Spring",
            "Learn to Dance"
        );
        
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_WithEmptyList() {
        List<String> todos = Collections.emptyList();
        
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(0, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingBDD() {
        // Given
        List<String> todos = Arrays.asList(
            "Learn Spring MVC",
            "Learn Spring",
            "Learn to Dance"
        );
        
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        // When
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        // Then
        assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_UsingBDD() {
        // Given
        List<String> todos = Arrays.asList(
            "Learn Spring MVC",
            "Learn Spring",
            "Learn to Dance"
        );
        
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        // Then (then() lines are BDD equivalents to the lines above them)
        verify(todoServiceMock).deleteTodo("Learn to Dance");
        then(todoServiceMock).should().deleteTodo("Learn to Dance");
        // verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
        verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to Dance");
        then(todoServiceMock).should(atLeastOnce()).deleteTodo("Learn to Dance");
        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
        verify(todoServiceMock, never()).deleteTodo("Learn Spring");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_UsingBDD_ArgumentCapture() {
        // Given
        List<String> todos = Arrays.asList(
            "Learn Spring MVC",
            "Learn Spring",
            "Learn to Dance"
        );
        
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        // Then
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_UsingBDD_ArgumentCaptureMultipleTimes() {
        // Given
        List<String> todos = Arrays.asList(
            "Learn Java",
            "Learn Spring",
            "Learn to Dance"
        );
        
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        // Then
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }
}
