package com.abbos.dockerexample.util;

import com.abbos.dockerexample.entity.User;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 03/December/2024  18:33
 **/
@Component
public class DataGenerator {
    private Faker faker;

    @PostConstruct
    public void init() {
        faker = new Faker();
    }

    public List<User> generateData() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User().toBuilder()
                    .username(faker.name().firstName())
                    .password(faker.internet().password())
                    .mail(faker.internet().emailAddress())
                    .build();
            users.add(u);
        }
        return users;
    }
}
