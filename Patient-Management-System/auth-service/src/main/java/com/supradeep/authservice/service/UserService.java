package com.supradeep.authservice.service;

import com.supradeep.authservice.model.User;
import com.supradeep.authservice.repository.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }
}
