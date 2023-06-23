package com.makara.SystemPhone.service;

import com.makara.SystemPhone.entity.Brand;

import java.util.List;

public interface BrandService {
    Brand create(Brand brand);
    Brand getById(Integer id);
    Brand update(Integer id, Brand brandUpdate);
    List<Brand> getBrands();
    List<Brand> getBrands(String name);
    List<Brand> getBrandsCon(String name);

}
