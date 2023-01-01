package com.akkulov.telegramvkbot.service;

import com.akkulov.telegramvkbot.entity.UserEntity;
import com.akkulov.telegramvkbot.repository.SimpleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SimpleService {

  private final SimpleRepository simpleRepository;

  public UserEntity getUser() {
    return simpleRepository.getUser().orElseThrow();
  }
}
