package com.makara.SystemPhone.controller;
import com.makara.SystemPhone.dto.BrandDTO;
import com.makara.SystemPhone.dto.PageDTO;
import com.makara.SystemPhone.entity.Brand;
import com.makara.SystemPhone.mapper.BrandMapper;
import com.makara.SystemPhone.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
        Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
        brand = brandService.create(brand);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
        Brand brand = brandService.getById(brandId);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO){
        Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
        Brand updatedBrand = brandService.update(brandId, brand);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updatedBrand));
    }

    @GetMapping
    public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params){
        Page<Brand> page = brandService.getBrands(params);

        PageDTO pageDTO = new PageDTO(page);

        return ResponseEntity.ok(pageDTO);
    }


}


