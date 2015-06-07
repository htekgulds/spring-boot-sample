package com.htds.spring.samples;

import com.google.common.base.Joiner;
import com.htds.spring.samples.repository.UserRepository;
import com.htds.spring.samples.util.TestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.inject.Inject;

/**
 * Created by Hasan
 * on 3.6.2015.
 */

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Inject
    private UserRepository userRepository;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        addLiquibaseScanPackages();
    }

    @Override
    public void run(String... strings) throws Exception {
        log.debug("***************************************");
        log.debug("Adding fake users");
        log.debug("***************************************");

        TestUtils.addTestUsers(userRepository);

        log.debug("***************************************");
        log.debug("Finished adding fake users");
        log.debug("***************************************");
    }

    private static void addLiquibaseScanPackages() {
        System.setProperty("liquibase.scan.packages", Joiner.on(",").join(
                "liquibase.change", "liquibase.database", "liquibase.parser",
                "liquibase.precondition", "liquibase.datatype",
                "liquibase.serializer", "liquibase.sqlgenerator", "liquibase.executor",
                "liquibase.snapshot", "liquibase.logging", "liquibase.diff",
                "liquibase.structure", "liquibase.structurecompare", "liquibase.lockservice",
                "liquibase.ext", "liquibase.changelog"));
    }
}
