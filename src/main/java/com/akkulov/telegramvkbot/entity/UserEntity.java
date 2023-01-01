package com.akkulov.telegramvkbot.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class UserEntity {

  private final Long id;
  private final String name;
  private final String surname;
}
