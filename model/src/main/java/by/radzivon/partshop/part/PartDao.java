package by.radzivon.partshop.part;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PartDao {
    ResultSet getPartById(Long id) throws SQLException;
    ResultSet getPartByName(String name) throws SQLException;
    ResultSet save(Part part) throws SQLException;
    ResultSet getAll() throws SQLException;
}
