package ru.itis.repository;

import ru.itis.model.Exhibition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ExhibitionRepositoryImpl implements ExhibitionRepository {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM exhibitions";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM exhibitions WHERE exhibition_id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM exhibitions WHERE exhibition_id = ?";
    private static final String INSERT_QUERY = "INSERT INTO exhibitions (exhibition_id, name, start_date, end_date) VALUES (?, ?, ?, ?)";
    private static final String GET_EXHIBITIONS_BY_VISITOR_ID = "select e.exhibition_id,e.name,e.start_date,e.end_date from visitor_exhibitions ve join exhibitions e on ve.exhibition_id = e.exhibition_id where visitor_id = ?";
    private static final String FIND_BY_EXHIBITION_ID_AND_VISITOR_ID = "select * from visitor_exhibitions where visitor_id = ? and exhibition_id = ?";
    private static final String INSERT_IN_VISITOR_EXHIBITIONS = "insert into visitor_exhibitions values (?,?)";
    @Override
    public List<Exhibition> getAll() {
        List<Exhibition> exhibitions = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Long id = resultSet.getLong("exhibition_id");
                    String name = resultSet.getString("name");
                    Date startDate = resultSet.getDate("start_date");
                    Date endDate = resultSet.getDate("end_date");
                    exhibitions.add(new Exhibition(id, name, startDate, endDate));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return exhibitions;
    }

    @Override
    public Optional<Exhibition> findById(Long id) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    Date startDate = resultSet.getDate("start_date");
                    Date endDate = resultSet.getDate("end_date");
                    return Optional.of(new Exhibition(id, name, startDate, endDate));
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
    public void save(Exhibition exhibition) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
                preparedStatement.setLong(1, exhibition.getExhibitionId());
                preparedStatement.setString(2, exhibition.getName());
                preparedStatement.setDate(3, new java.sql.Date(exhibition.getStartDate().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(exhibition.getEndDate().getTime()));
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
    public List<Exhibition> getExhibitionsByVisitor(Long id) {
        List<Exhibition> exhibitions = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(GET_EXHIBITIONS_BY_VISITOR_ID)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Long exhibitionId = resultSet.getLong("exhibition_id");
                    String name = resultSet.getString("name");
                    Date startDate = resultSet.getDate("start_date");
                    Date endDate = resultSet.getDate("end_date");
                    exhibitions.add(new Exhibition(exhibitionId, name, startDate, endDate));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return exhibitions;
    }
    @Override
    public void saveInVisitorExhibitions(Long visitorId,Long exhibitionId) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_IN_VISITOR_EXHIBITIONS)) {
                preparedStatement.setLong(1, visitorId);
                preparedStatement.setLong(2, exhibitionId);
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
    public boolean isVisitorRegisteredForExhibition(Long visitorId, Long exhibitionId) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_EXHIBITION_ID_AND_VISITOR_ID)) {
                preparedStatement.setLong(1, visitorId);
                preparedStatement.setLong(2, exhibitionId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return false;
    }
}
