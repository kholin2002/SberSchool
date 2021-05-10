package com.github.kholin.jdbcexample;

import com.github.kholin.ExampleJDBC;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleJDBCIT {

    private ExampleJDBC exampleJDBC = new ExampleJDBC("jdbc:h2:target/example");

    @Data
    @AllArgsConstructor
    private static class Animal {
        private int age;
        private String name;
    }

    @BeforeAll
    static void setUp() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
    }

    @Test
    void selectExample() throws SQLException {
        String sql = "SELECT * FROM animal WHERE age = ? AND name like ?";
        Object[] params = new Object[] {10, "DEX%"};
        Function<Map<String, Object>, Animal> foo = m -> { return new Animal((Integer) m.get("AGE"), (String) m.get("NAME")); };
        assertEquals(Optional.of(new Animal(10, "DEXTER")), exampleJDBC.select(sql, params, foo).findFirst());
    }
}
