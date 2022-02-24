package com.example.querydsl.account;

import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud(){
        Predicate predicate = QAccount.account.firstName.containsIgnoreCase("keesun")
                .and(QAccount.account.lastName.startsWith("baik"));

        Optional<Account> one = accountRepository.findOne(predicate);
        assertThat(one).isEmpty();

    }

}