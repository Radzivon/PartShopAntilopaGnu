package by.radzivon.partshop.service.userpart;

import by.radzivon.partshop.entity.UserPart;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.repository.UserPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserPartServiceImpl implements UserPartService {
    private UserPartRepository partRepository;

    @Autowired
    public UserPartServiceImpl(UserPartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public UserPart getById(Long id) throws ResourceNotFoundException {
        return partRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Part don't exist with id " + id));
    }

    @Override
    public void save(UserPart part) {
        partRepository.save(part);
    }

    @Override
    public List<UserPart> getAll() {
        return partRepository.findAll();
    }

    @Override
    public void deletePart(UserPart part) {
        partRepository.delete(part);
    }

    @Override
    public void editPart(UserPart part) {
        partRepository.save(part);
    }
}
