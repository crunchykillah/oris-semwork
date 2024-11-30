package ru.itis.repository;

import ru.itis.model.Artwork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArtworkRepositoryImpl implements ArtworkRepository {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM artworks";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM artworks WHERE artwork_id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM artworks WHERE artwork_id = ?";
    private static final String INSERT_QUERY = "INSERT INTO artworks (artwork_id, title, creation_year, author_id) VALUES (?, ?, ?, ?)";
    private static final String FIND_BY_AUTHOR_QUERY = "SELECT * FROM artworks WHERE author_id = ?";
    private static final String FIND_ARTWORKS_BY_EXHIBITION = "select a.artwork_id, a.title, a.creation_year,a.author_id from exhibition_artworks join artworks a on exhibition_artworks.artwork_id = a.artwork_id where exhibition_id = ?";
    private static AuthorRepositoryImpl authorRepository = new AuthorRepositoryImpl();
    @Override
    public List<Artwork> getAll() {
        List<Artwork> artworks = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Long id = resultSet.getLong("artwork_id");
                    String title = resultSet.getString("title");
                    Integer creationYear = resultSet.getInt("creation_year");
                    Long authorId = resultSet.getLong("author_id");
                    artworks.add(new Artwork(id, title, creationYear, authorRepository.findById(authorId).get()));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return artworks;
    }

    @Override
    public Optional<Artwork> findById(Long id) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String title = resultSet.getString("title");
                    Integer creationYear = resultSet.getInt("creation_year");
                    Long authorId = resultSet.getLong("author_id");
                    return Optional.of(new Artwork(id, title, creationYear, authorRepository.findById(authorId).get()));
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
    public void save(Artwork artwork) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
                preparedStatement.setLong(1, artwork.getArtworkId());
                preparedStatement.setString(2, artwork.getTitle());
                preparedStatement.setInt(3, artwork.getCreationYear());
                preparedStatement.setLong(4, artwork.getAuthor().getAuthorId());
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
    @Override
    public List<Artwork> findArtworksByAuthor(Long authorId) {
        List<Artwork> artworks = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_AUTHOR_QUERY)) {
                preparedStatement.setLong(1, authorId);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Long id = resultSet.getLong("artwork_id");
                    String title = resultSet.getString("title");
                    Integer creationYear = resultSet.getInt("creation_year");
                    artworks.add(new Artwork(id, title, creationYear, authorRepository.findById(authorId).get()));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return artworks;
    }
    @Override
    public List<Artwork> getArtworksByExhibitionId(Long id) {
        List<Artwork> artworks = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ARTWORKS_BY_EXHIBITION);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Long artworkId = resultSet.getLong("artwork_id");
                    String title = resultSet.getString("title");
                    Integer creationYear = resultSet.getInt("creation_year");
                    Long authorId = resultSet.getLong("author_id");
                    artworks.add(new Artwork(artworkId, title, creationYear, authorRepository.findById(authorId).get()));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return artworks;
    }

}
