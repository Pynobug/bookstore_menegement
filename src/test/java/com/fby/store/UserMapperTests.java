package com.fby.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;


@SpringBootTest
class UserMapperTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void getConnections() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

}
