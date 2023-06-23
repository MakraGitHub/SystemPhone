package com.makara.SystemPhone.service.impl;

import com.makara.SystemPhone.entity.Brand;
import com.makara.SystemPhone.exception.ResourceNotFoundException;
import com.makara.SystemPhone.repository.BrandRepository;
import com.makara.SystemPhone.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }
    @Override
    public Brand getById(Integer id) {

        return brandRepository.findById(id).
                  orElseThrow(()->new ResourceNotFoundException("brand",id));
    }
    @Override
    public Brand update(Integer id, Brand brandUpdate) {
         Brand brand = getById(id);
         brand.setName(brandUpdate.getName()); //@TODO improve update.
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getBrands() {
       return brandRepository.findAll();

    }
    @Override
    public List<Brand> getBrands(String name) {
        return brandRepository.findByNameLike("%"+name + "%");

    }
    @Override
    public List<Brand> getBrandsCon(String name){
        return brandRepository.findByNameContaining(name);
    }
}
