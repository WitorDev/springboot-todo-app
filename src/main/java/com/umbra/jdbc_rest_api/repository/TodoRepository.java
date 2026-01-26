package com.umbra.jdbc_rest_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.umbra.jdbc_rest_api.model.Todo;

@Repository
public class TodoRepository {

  private final JdbcTemplate jdbcTemplate;
  private final RowMapper<Todo> rowMapper = new TodoRowMapper();

  public TodoRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Todo> findAll() {
    String sql = """
        SELECT id, title, completed, created_at
        FROM todos
        ORDER BY created_at ASC;
                """;

    return jdbcTemplate.query(sql, rowMapper);
  }

  public Optional<Todo> findById(Long id) {
    String sql = """
            SELECT id, title, completed, created_at
            FROM todos
            WHERE id = ?
        """;

    List<Todo> result = jdbcTemplate.query(sql, rowMapper, id);
    return result.stream().findFirst();
  }

  public Todo save(String title) {
    String sql = """
            INSERT INTO todos (title, completed)
            VALUES (?, false)
            RETURNING id
        """;

    Long id = jdbcTemplate.queryForObject(sql, Long.class, title);
    return findById(id).orElseThrow();
  }

  public int update(Long id, String title, boolean completed) {
    String sql = """
            UPDATE todos
            SET title = ?, completed = ?
            WHERE id = ?
        """;

    return jdbcTemplate.update(sql, title, completed, id);
  }

  public void delete(Long id) {
    String sql = "DELETE FROM todos WHERE id = ?";
    jdbcTemplate.update(sql, id);
  }
}
