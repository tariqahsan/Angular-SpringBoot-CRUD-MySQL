package org.mma.training.java.spring.service;

import java.util.List;

import org.mma.training.java.spring.model.User;

public interface IUserService {
     List<User> getAllUsers();
     User getUserById(long articleId);
     boolean addUser(User article);
     void updateUser(User article);
     void deleteUser(int articleId);
}
