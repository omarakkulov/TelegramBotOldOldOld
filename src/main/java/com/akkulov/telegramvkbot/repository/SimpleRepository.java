package com.akkulov.telegramvkbot.repository;

import static com.akkulov.telegramvkbot.jooq.tables.Users.USERS;

import com.akkulov.telegramvkbot.entity.UserEntity;
import com.akkulov.telegramvkbot.jooq.tables.records.UsersRecord;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SimpleRepository {

  private final DSLContext dslContext;

  @Transactional(readOnly = true)
  public Optional<UserEntity> getUser() {
    var userOpt = dslContext.selectFrom(USERS)
        .where(USERS.NAME.eq("Omar"))
        .fetchOptional();

    if (userOpt.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(convertToEntityObject(userOpt.get()));
  }

  private UserEntity convertToEntityObject(UsersRecord usersRecord) {
    return UserEntity.builder()
        .id(usersRecord.getId())
        .name(usersRecord.getName())
        .surname(usersRecord.getSurname())
        .build();
  }
}
