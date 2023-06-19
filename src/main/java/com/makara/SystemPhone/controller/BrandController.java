package com.makara.SystemPhone.controller;
// this is concept spring mvc

import com.makara.SystemPhone.dto.BrandDTO;
import com.makara.SystemPhone.entity.Brand;
import com.makara.SystemPhone.mapper.BrandMapper;
import com.makara.SystemPhone.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("brands")
@Slf4j
public class BrandController {

    @Autowired
    public BrandService brandService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
        Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
       brand = brandService.create(brand);     // This is save data to db.
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
        //This is headeler method.

    }
    @GetMapping("{id}")
    public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){

        Brand brand = brandService.getById(brandId);
        return  ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer brandId,@RequestBody BrandDTO brandDTO){
        Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
        Brand updatedBrand = brandService.update(brandId,brand);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updatedBrand));
    }
    

}
