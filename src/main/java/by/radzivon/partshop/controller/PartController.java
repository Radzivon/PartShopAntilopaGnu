package by.radzivon.partshop.controller;

import by.radzivon.partshop.dto.PartDto;
import by.radzivon.partshop.entity.Part;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.service.part.PartService;
import by.radzivon.partshop.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/part")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class PartController {
    private PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping(value = "/{id}")
    public PartDto partPage(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return Mapper.map(partService.getById(id), PartDto.class);
    }

    @GetMapping(value = {"/all"})
    public Page<PartDto> partsPage(@RequestParam(defaultValue = "0") int pageNo,
                                   @RequestParam(defaultValue = "20") int pageSize,
                                   @RequestParam(defaultValue = "id") String sortBy,
                                   @RequestParam(defaultValue = "asc") String sortDir) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(sortDir), sortBy);
        return partService.getAll(paging).map(this::convertToDto);
    }

    @PostMapping(value = {"/add"})
    @ResponseStatus(HttpStatus.CREATED)
    public void savePart(@Valid @RequestBody PartDto partDto) {
        partService.save(Mapper.map(partDto, Part.class));
        log.info("part/add");

    }

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editPart(@PathVariable("id") Long id, @Valid @RequestBody PartDto partDto) {
        partService.editPart(Mapper.map(partDto, Part.class));
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePerson(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Part part = partService.getById(id);
        partService.deletePart(part);
        log.info("part/delete with id " + id);
    }

    private PartDto convertToDto(Part part) {
        return Mapper.map(part, PartDto.class);
    }
}
