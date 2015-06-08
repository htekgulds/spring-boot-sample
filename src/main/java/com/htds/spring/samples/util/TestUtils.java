package com.htds.spring.samples.util;

import com.htds.spring.samples.domain.User;
import com.htds.spring.samples.repository.UserRepository;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Hasan
 * on 4.6.2015.
 */
public class TestUtils {
    private static final Logger log = LoggerFactory.getLogger(TestUtils.class);

    public static void addTestUsers(UserRepository repo) {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();

        User user = new User();
        user.setFirstName(person.firstName());
        user.setLastName(person.lastName());
        user.setEmail(person.email());
        user.setLogin(person.username());
        user.setPasswordHash("123456");
        repo.save(user);
        log.debug("Created User: {}", user);
    }
}
