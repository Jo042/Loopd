package com.loopd.repository;

import com.loopd.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getObject("id", UUID.class));
        user.setEmail(rs.getString("email"));
        user.setDisplayName(rs.getString("display_name"));
        user.setAvatarUrl(rs.getString("avatar_url"));
        user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return user;
    };

    public Optional<User> findById(String id) {
        String sql = "SELECT * FROM users WHERE id = ?::uuid";
        return jdbcTemplate.query(sql, userRowMapper, id)
                .stream().findFirst();
    }

    public User create(String id, String email, String displayName) {
        String sql = "INSERT INTO users (id, email, display_name) VALUES (?::uuid, ?, ?) RETURNING *";
        return jdbcTemplate.queryForObject(sql, userRowMapper, id, email, displayName);
    }
}
