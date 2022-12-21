package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MainService {
  @Autowired(required = false)
  private UserRepository userRepository;

  public User getUserProfile() {
    log.info("[LOG] mainService.getUserProfile is called");
    return userRepository.findAll().get(0);
  }

  public User updateUserProfile(User updatedUser) {
    log.info("[LOG] mainService.updateUserProfile is called");
    log.info("[LOG] updatedUser.getName(): " + updatedUser.getName());
    log.info("[LOG] updatedUser.getEmail(): " + updatedUser.getEmail());
    log.info("[LOG] updatedUser.getInterests(): " + updatedUser.getInterests());

    try {
      log.info("[LOG] TRY BLOCK ENTERED");
      userRepository.findAll().get(0);

      User updatedUserWithId = new User(1L, updatedUser.getName(), updatedUser.getEmail(), updatedUser.getInterests());
      log.info("[LOG] updatedUserWithId: " + updatedUserWithId);

      userRepository.save(updatedUserWithId);
      log.info("[LOG] userRepository.save is called");

      log.info("[LOG] userRepository.findAll(): "+userRepository.findAll());
    } catch(Exception e) {
      log.info("[LOG] EXCEPTION BLOCK ENTERED");

      User updatedUserWithId = new User(updatedUser.getName(), updatedUser.getEmail(), updatedUser.getInterests());
      log.info("[LOG] updatedUserWithId: " + updatedUserWithId);

      userRepository.save(updatedUserWithId);
      log.info("[LOG] userRepository.save is called");

      log.info("[LOG] userRepository.findAll(): "+userRepository.findAll());
    }
    return userRepository.findAll().get(0);
  }
}
