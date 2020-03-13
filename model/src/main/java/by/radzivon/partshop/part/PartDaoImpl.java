package by.radzivon.partshop.part;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PartDaoImpl implements PartDao {

    @Override
    public ResultSet getPartById(Long id) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getPartByName(String name) throws SQLException {
        return null;
    }

    @Override
    public ResultSet save(Part part) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return null;
    }
}
