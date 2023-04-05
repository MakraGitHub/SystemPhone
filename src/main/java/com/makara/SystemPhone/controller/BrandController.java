package com.makara.SystemPhone.controller;
// this is concept spring mvc

import com.makara.SystemPhone.dto.BrandDTO;
import com.makara.SystemPhone.entity.Brand;
import com.makara.SystemPhone.service.BrandService;
import com.makara.SystemPhone.service.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brands")
public class BrandController {

    @Autowired
    public BrandService brandService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
        Brand brand = Mapper.toBrand(brandDTO);
       brand = brandService.create(brand);     // This is save data to db.
        return ResponseEntity.ok(Mapper.brandDTO(brand));
        //This is headeler method.

    }

}
