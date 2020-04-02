package by.radzivon.partshop.controller;

import by.radzivon.partshop.dto.CommentDto;
import by.radzivon.partshop.entity.Comment;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.service.comment.CommentService;
import by.radzivon.partshop.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/{id}")
    public CommentDto commentById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        log.info("comment/" + id);
        return Mapper.map(commentService.getById(id), CommentDto.class);
    }

    @GetMapping(value = {"/all"})
    public @ResponseBody
    List<CommentDto> commentList() {
        log.info("comment/all");
        return Mapper.mapAll(commentService.getAll(), CommentDto.class);
    }

    @PostMapping(value = {"/add"})
    @ResponseStatus(HttpStatus.CREATED)
    public void saveComment(@Valid @RequestBody CommentDto commentDto) {
        commentService.save(Mapper.map(commentDto, Comment.class));
        log.info("comment/add");

    }

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editUser(@PathVariable("id") Long id, @RequestBody CommentDto commentDto) {
        commentService.update(Mapper.map(commentDto, Comment.class));
        log.info("comment/edit/" + id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePerson(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Comment comment = commentService.getById(id);
        commentService.delete(comment);
        log.info("comment/delete with id " + id);
    }
}


