package com.htds.spring.samples.util;

import com.htds.spring.samples.domain.User;
import com.htds.spring.samples.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Hasan
 * on 4.6.2015.
 */
public class TestUtils {
    private static final Logger log = LoggerFactory.getLogger(TestUtils.class);

    public static void addTestUsers(UserRepository repo) {
        User user = new User();
        user.setFirstName("Admin");
        user.setLastName("ADMIN");
        user.setEmail("admin@localhost.com");
        user.setLogin("admin");
        user.setPasswordHash("123456");
        repo.save(user);
        log.debug("Created User: {}", user);
    }
}
