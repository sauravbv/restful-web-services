package com.in23minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	
	private static List<Todo> todos =new ArrayList<>();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "saurav", "Learn Angular", new Date(), false));
		todos.add(new Todo(++idCounter, "saurav", "Learn Spring boot", new Date(), false));
		todos.add(new Todo(++idCounter, "saurav", "Learn to dance", new Date(), false));	
	}
	
	public List<Todo> findAll(){
		System.out.println(todos);
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findbyId(id);
		
		System.out.println("this is test of hardcoded");
		
		if(todo == null) { return null;}
		if(todos.remove(todo)) {
		return todo;
		}
		return null;
	}

	public Todo findbyId(long id) {
		
		for(Todo todo: todos) {
			if(todo.getId() == id) {
				return todo;
			}else
				return null;
		}
		return null;
	}
	
	
	

}
