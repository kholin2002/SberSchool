package com.github.kholin;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class ExampleJDBC {
    private String url;

    public ExampleJDBC(String url) {
        this.url = url;
    }

    public <T> Stream<T> select(String sql, Object[] params, Function<Map<String, Object>, T> foo) throws SQLException {
        try (Connection connection = getConnection().orElseThrow(JDBCConnectionException::new);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setStatementParams(preparedStatement, params);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                Stream.Builder<T> stream = Stream.builder();
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                HashMap<String, Object> map = new HashMap<>();
                while (resultSet.next()) {
                    for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                        map.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
                    }
                    stream.add(foo.apply(map));
                }
                return stream.build();
            }
        }
    }

    private void setStatementParams(PreparedStatement preparedStatement, Object[] params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
        }
    }

    private Optional<Connection> getConnection() throws SQLException {
        return Optional.ofNullable(DriverManager.getConnection(url));
    }

}
