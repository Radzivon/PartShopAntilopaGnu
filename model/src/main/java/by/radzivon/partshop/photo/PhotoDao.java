package by.radzivon.partshop.photo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PhotoDao {
    ResultSet getPhotoById(Long id) throws SQLException;
    void save(Photo photo) throws SQLException;
    void savePhotos(List<Photo> photos) throws SQLException;
    void update(Long id, String comment) throws SQLException;
    ResultSet getPhotosByPartId(Long partId) throws SQLException;
    ResultSet getAll() throws SQLException;
}
