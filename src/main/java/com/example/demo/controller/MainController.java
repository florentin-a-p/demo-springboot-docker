package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.MainService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@Slf4j
public class MainController {
  @Autowired
  MainService mainService;

  @GetMapping(path="/get-profile")
  public User getProfile() {
    log.info("[LOG] mainController.getProfile is called");
    return mainService.getUserProfile();
  }

  @PostMapping(path="/update-profile")
  public User updateProfile(@RequestBody User updatedUser) {
    log.info("[LOG] mainController.updateProfile is called");
    return mainService.updateUserProfile(updatedUser);
  }

}
