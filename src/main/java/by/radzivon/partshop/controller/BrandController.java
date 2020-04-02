package by.radzivon.partshop.controller;

import by.radzivon.partshop.dto.BrandDto;
import by.radzivon.partshop.dto.PartDto;
import by.radzivon.partshop.entity.Brand;
import by.radzivon.partshop.entity.Part;
import by.radzivon.partshop.exception.ResourceNotFoundException;
import by.radzivon.partshop.service.brand.BrandService;
import by.radzivon.partshop.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class BrandController {

    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping(value = "/{id}")
    public BrandDto brand(@PathVariable("id") Long id) throws ResourceNotFoundException {
        log.info("brand/" + id);
        return Mapper.map(brandService.getById(id), BrandDto.class);
    }

    @GetMapping(value = {"/all"})
    public @ResponseBody
    List<BrandDto> brandList() {
        log.info("brand/all");
        return Mapper.mapAll(brandService.getAll(), BrandDto.class);
    }

    @PostMapping(value = {"/add"})
    @ResponseStatus(HttpStatus.CREATED)
    public void savePart(@Valid @RequestBody BrandDto brandDto) {
        brandService.save(Mapper.map(brandDto, Brand.class));
        log.info("brand/add");

    }

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editPart(@PathVariable("id") Long id, @RequestBody BrandDto brandDto) {
        brandService.editBrand(Mapper.map(brandDto, Brand.class));
        log.info("brand/edit/" + id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePerson(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Brand brand = brandService.getById(id);
        brandService.deleteBrand(brand);
        log.info("brand/delete with id " + id);
    }
}

