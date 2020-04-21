package by.radzivon.partshop.repository;

import by.radzivon.partshop.entity.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartRepository extends PagingAndSortingRepository<Part, Long> {
    Part save(Part part);

    Page<Part> findAll(Pageable pageable);

    Optional<Part> findById(Long id);

    Optional<Part> findByCategory(String category);
}
