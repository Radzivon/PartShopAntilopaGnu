package by.radzivon.partshop.service.comment;

import by.radzivon.partshop.entity.Comment;
import by.radzivon.partshop.exception.ResourceNotFoundException;

import java.util.List;

public interface CommentService {
    Comment getById(Long id) throws ResourceNotFoundException;

    void save(Comment comment);

    void delete(Comment comment);

    List<Comment> getAll();

    void update(Comment comment);
}
