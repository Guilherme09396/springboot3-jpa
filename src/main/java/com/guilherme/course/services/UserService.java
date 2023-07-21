package com.guilherme.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.course.entities.User;
import com.guilherme.course.repositories.UserRepository;
import com.guilherme.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		User user = repository.getReferenceById(id);
		repository.delete(user);
	}
	
	public User update(Long id, User obj) {
		User user = repository.getReferenceById(id);
		updateUser(user, obj);
		return repository.save(user);
	}
	
	private void updateUser(User user, User obj) {
		user.setEmail(obj.getEmail());
		user.setName(obj.getName());
		user.setPhone(obj.getPhone());
	}
}
