package by.radzivon.partshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private long id;
    private String text;

    private long photoId;
}
