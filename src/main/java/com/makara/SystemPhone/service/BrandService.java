package com.makara.SystemPhone.service;

import com.makara.SystemPhone.entity.Brand;

public interface BrandService {
    Brand create(Brand brand);
    Brand getById(Integer id);
    Brand update(Integer id, Brand brandUpdate);

}
