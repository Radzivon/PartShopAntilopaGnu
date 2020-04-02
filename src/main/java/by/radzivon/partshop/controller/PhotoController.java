package by.radzivon.partshop.controller;

import by.radzivon.partshop.dto.CommentDto;
import by.radzivon.partshop.dto.PhotoDto;
import by.radzivon.partshop.entity.Comment;
import by.radzivon.partshop.entity.Photo;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.service.comment.CommentService;
import by.radzivon.partshop.service.photo.PhotoService;
import by.radzivon.partshop.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/photo")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class PhotoController {

    private PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService commentService) {
        this.photoService = commentService;
    }

    @GetMapping(value = "/{id}")
    public PhotoDto commentById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        log.info("photo/" + id);
        return Mapper.map(photoService.getById(id), PhotoDto.class);
    }

    @GetMapping(value = {"/all"})
    public @ResponseBody
    List<PhotoDto> commentList() {
        log.info("photo/all");
        return Mapper.mapAll(photoService.getAll(), PhotoDto.class);
    }

    @PostMapping(value = {"/add"})
    @ResponseStatus(HttpStatus.CREATED)
    public void saveComment(@Valid @RequestBody PhotoDto commentDto) {
        photoService.save(Mapper.map(commentDto, Photo.class));
        log.info("photo/add");

    }

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editUser(@PathVariable("id") Long id, @RequestBody CommentDto commentDto) {
        photoService.update(Mapper.map(commentDto, Photo.class));
        log.info("photo/edit/" + id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePerson(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Photo photo = photoService.getById(id);
        photoService.delete(photo);
        log.info("photo/delete with id " + id);
    }
}



