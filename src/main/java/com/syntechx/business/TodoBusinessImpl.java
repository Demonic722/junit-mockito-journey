package com.syntechx.business;

import java.util.List;
import java.util.stream.Collectors;

import com.syntechx.data.api.TodoService;

/**
 * TodoBusinessImpl - SystemUnderTest (SUT)
 * TodoService - Dependency
 */
public class TodoBusinessImpl {

    private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
    }
    
    public List<String> retrieveTodosRelatedToSpring(String user) {
        return
            todoService
                .retrieveTodos(user)
                .stream()
                .filter(t -> t.contains("Spring"))
                .collect(Collectors.toList());
    }
}
