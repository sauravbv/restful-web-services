package com.in23minutes.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoJPAResource {

	@Autowired
	private TodoHardcodedService todoService;
	
	@Autowired
	private TodoJPARepository todoJPARepository;

	@GetMapping("jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoJPARepository.findByUsername(username);
		//return todoService.findAll();
	}
	
	@GetMapping("jpa/users/{username}/todos/{id}")
	public Todo getTodos(@PathVariable String username, @PathVariable long id) {
		return todoJPARepository.findById(id).get();
		//return todoService.findbyId(id);
	}
	
	@PutMapping("jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo) {

//		Todo todoUpdated = todoService.save(todo);
		Todo todoUpdated = todoJPARepository.save(todo);
		
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	

	@DeleteMapping("jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		//Todo todo = todoService.deleteById(id);
		//if (todo != null) {
			
		todoJPARepository.deleteById(id);
		return ResponseEntity.noContent().build();
		
		//return ResponseEntity.notFound().build();

	}
	
	@PostMapping("jpa/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String username,@RequestBody Todo todo ) {
		//Todo createdTodo = todoService.save(todo);	
		
		todo.setUsername(username);
		Todo createdTodo = todoJPARepository.save(todo);

		URI uri =	ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();

	}
	
	
	
}
