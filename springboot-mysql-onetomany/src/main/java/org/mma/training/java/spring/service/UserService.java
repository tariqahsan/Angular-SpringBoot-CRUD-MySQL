package org.mma.training.java.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.mma.training.java.spring.model.User;
import org.mma.training.java.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public User getUserById(long userId) {
		User obj = userRepository.findById(userId).get();
		return obj;
	}	
	@Override
	public List<User> getAllUsers(){
		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	
	@Override
	public synchronized boolean addUser(User user){

		User u = getUserById(user.getUserId());
		
       if (u != null) {
    	   return false;
       } else {
    	   userRepository.save(user);
    	   return true;
       }
	}
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}
	@Override
	public void deleteUser(int userId) {
		userRepository.delete(getUserById(userId));
	}
}
