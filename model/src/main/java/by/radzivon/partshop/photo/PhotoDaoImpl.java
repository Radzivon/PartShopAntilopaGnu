package by.radzivon.partshop.photo;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PhotoDaoImpl implements PhotoDao {

    @Override
    public ResultSet getPhotoById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void save(Photo photo) throws SQLException {

    }

    @Override
    public void savePhotos(List<Photo> photos) throws SQLException {

    }

    @Override
    public void update(Long id, String comment) throws SQLException {

    }

    @Override
    public ResultSet getPhotosByPartId(Long partId) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return null;
    }
}
