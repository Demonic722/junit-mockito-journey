package com.syntechx.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.syntechx.data.api.TodoService;
import com.syntechx.data.api.TodoServiceStub;

import org.junit.Test;

public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingAStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2, filteredTodos.size());
    }
}
