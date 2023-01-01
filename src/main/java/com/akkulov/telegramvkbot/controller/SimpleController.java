package com.akkulov.telegramvkbot.controller;

import com.akkulov.telegramvkbot.service.SimpleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class SimpleController {

  private final SimpleService simpleService;

  @GetMapping("get")
  public String getUser() {
    return simpleService.getUser().toString();
  }
}
