package com.htds.spring.samples.controller;

import com.htds.spring.samples.repository.UserRepository;
import com.htds.spring.samples.resource.UserResource;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Hasan
 * on 4.6.2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserResourceTest {

    @Mock
    private UserRepository userRepository;

    private UserResource userResource;

    @Before
    public void setUp() {
//        userResource = new UserResource(userRepository);
    }
}
