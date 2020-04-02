package by.radzivon.partshop.dto;

import by.radzivon.partshop.entity.Comment;
import by.radzivon.partshop.entity.Part;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class PhotoDto {
    private long id;
    private String imageUrl;
    private Date dateOfDownload;
    private Set<CommentDto> comments;
    private long partId;
}
