package com.htds.spring.samples.controller;

import com.htds.spring.samples.Application;
import com.htds.spring.samples.repository.UserRepository;
import com.htds.spring.samples.resource.UserResource;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

/**
 * Created by Hasan
 * on 4.6.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class UserResourceTest {

    @Inject
    private UserRepository userRepository;

    private UserResource userResource;

    @Before
    public void setUp() {
//        userResource = new UserResource(userRepository);
    }
}
