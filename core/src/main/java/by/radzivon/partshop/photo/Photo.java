package by.radzivon.partshop.photo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Photo implements Serializable {
    private Long id;
    private String imageUrl;
    private String comment;
    private LocalDate dateOfDownload;
    private Long partId;
}
