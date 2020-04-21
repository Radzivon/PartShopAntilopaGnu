package by.radzivon.partshop.service.userpart;

import by.radzivon.partshop.entity.Part;
import by.radzivon.partshop.entity.UserPart;
import by.radzivon.partshop.exception.ResourceNotFoundException;

import java.util.List;

public interface UserPartService {
    UserPart getById(Long id) throws ResourceNotFoundException;

    void save(UserPart part);

    List<UserPart> getAll();

    void deletePart(UserPart part);

    void editPart(UserPart part);
}
