package by.radzivon.partshop.service.comment;

import by.radzivon.partshop.entity.Comment;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment getById(Long id) throws ResourceNotFoundException {
        return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment doesn't exist with id " + id));
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> getAll() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public void update(Comment comment) {
        commentRepository.save(comment);
    }
}
