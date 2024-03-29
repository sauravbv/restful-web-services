package com.in23minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<>();
	private static long idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "saurav", "Learn Angular", new Date(), false));
		todos.add(new Todo(++idCounter, "saurav", "Learn Spring boot", new Date(), false));
		todos.add(new Todo(++idCounter, "saurav", "Learn to dance", new Date(), false));
	}

	public List<Todo> findAll() {
		System.out.println(todos);
		return todos;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public Todo deleteById(long id) {
		Todo todo = findbyId(id);
		if (todo == null) {
			return null;
		}
		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findbyId(long id) {

		for(Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			} 
		}
		return null;
	}

}
