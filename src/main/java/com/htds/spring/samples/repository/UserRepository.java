package com.htds.spring.samples.repository;

import com.htds.spring.samples.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Hasan
 * on 4.6.2015.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
