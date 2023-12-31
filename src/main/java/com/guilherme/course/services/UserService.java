package com.guilherme.course.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.guilherme.course.entities.User;
import com.guilherme.course.repositories.UserRepository;
import com.guilherme.course.services.exceptions.DatabaseException;
import com.guilherme.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		try {
			User user = repository.findById(id).get();
			repository.delete(user);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		} catch(NoSuchElementException e) {
			throw new ResourceNotFoundException();
		}
	}

	public User update(Long id, User obj) {
		try {
			User user = repository.getReferenceById(id);
			updateUser(user, obj);
			return repository.save(user);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException();
		}
	}

	private void updateUser(User user, User obj) {
		user.setEmail(obj.getEmail());
		user.setName(obj.getName());
		user.setPhone(obj.getPhone());
	}
}
