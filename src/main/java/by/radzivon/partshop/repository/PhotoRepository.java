package by.radzivon.partshop.repository;

import by.radzivon.partshop.entity.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {

    List<Photo> findAll();
}
