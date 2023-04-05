package com.makara.SystemPhone.service.impl;

import com.makara.SystemPhone.entity.Brand;
import com.makara.SystemPhone.repository.BrandRepository;
import com.makara.SystemPhone.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }
}
