package by.radzivon.partshop.user;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public ResultSet getUserById(Long id) throws SQLException {
        return null;
    }

    @Override
    public ResultSet save(User user) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getUserByLogin(String name) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return null;
    }

    @Override
    public void deleteUserByLogin(String login) throws SQLException {

    }
}
