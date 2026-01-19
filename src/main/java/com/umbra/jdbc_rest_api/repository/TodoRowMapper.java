package com.umbra.jdbc_rest_api.repository;

import org.springframework.jdbc.core.RowMapper;

import com.umbra.jdbc_rest_api.model.Todo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoRowMapper implements RowMapper<Todo> {

  @Override
  public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
    Todo todo = new Todo();
    todo.setId(rs.getLong("id"));
    todo.setTitle(rs.getString("title"));
    todo.setCompleted(rs.getBoolean("completed"));
    todo.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
    return todo;
  }
}
