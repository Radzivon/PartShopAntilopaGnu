package by.radzivon.partshop.user;

import by.radzivon.partshop.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {
    ResultSet getUserById(final Long id) throws SQLException;
    ResultSet save(User user) throws SQLException;
    ResultSet getUserByLogin(String name) throws SQLException;
    ResultSet getAll() throws SQLException;
    void deleteUserByLogin(String login) throws SQLException;
}
