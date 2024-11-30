package ru.itis.repository;

import ru.itis.model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AuthorRepositoryImpl implements AuthorRepository {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM authors";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM authors WHERE author_id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM authors WHERE author_id = ?";
    private static final String INSERT_QUERY = "INSERT INTO authors (author_id, name, birth_date,death_date, country) VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Author> getAll() {
        List<Author> authors = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Long id = resultSet.getLong("author_id");
                    String name = resultSet.getString("name");
                    Date birthDate = resultSet.getDate("birth_date");
                    Date deathDate = resultSet.getDate("death_date");
                    String country = resultSet.getString("country");
                    authors.add(new Author(id, name, birthDate,deathDate, country));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return authors;
    }

    @Override
    public Optional<Author> findById(Long id) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    Date birthDate = resultSet.getDate("birth_date");
                    Date deathDate = resultSet.getDate("death_date");
                    String country = resultSet.getString("country");
                    return Optional.of(new Author(id, name, birthDate, deathDate, country));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_QUERY)) {
                preparedStatement.setLong(1, id);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
    }

    @Override
    public void save(Author author) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
                preparedStatement.setLong(1, author.getAuthorId());
                preparedStatement.setString(2, author.getName());
                preparedStatement.setDate(3, new java.sql.Date(author.getBirthDate().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(author.getDeathDate().getTime()));
                preparedStatement.setString(5, author.getCountry());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }

    }
}