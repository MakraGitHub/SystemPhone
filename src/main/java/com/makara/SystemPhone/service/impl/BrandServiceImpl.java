package com.makara.SystemPhone.service.impl;

import com.makara.SystemPhone.entity.Brand;
import com.makara.SystemPhone.exception.ResourceNotFoundException;
import com.makara.SystemPhone.repository.BrandRepository;
import com.makara.SystemPhone.service.BrandService;
import com.makara.SystemPhone.service.impl.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import com.makara.SystemPhone.spc.BrandFilter;
import com.makara.SystemPhone.spc.BrandSpec;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    @Autowired
    private final BrandRepository brandRepository;

    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand", id));
    }

    @Override
    public Brand update(Integer id, Brand brandUpdate) {
        Brand brand = getById(id);
        brand.setName(brandUpdate.getName()); // @TODO improve update
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getBrands(String name) {
        //return brandRepository.findByNameLike("%"+name + "%");
        return brandRepository.findByNameContaining(name);
    }

    @Override
    public Page<Brand> getBrands(Map<String, String> params) {
        BrandFilter brandFilter = new BrandFilter();

        if(params.containsKey("name")) {
            String name = params.get("name");
            brandFilter.setName(name);
        }

        if(params.containsKey("id")) {
            String id = params.get("id");
            brandFilter.setId(Integer.parseInt(id));
        }
        // @TODO add to a function for pageable
        int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
        if(params.containsKey(PageUtil.PAGE_LIMIT)) {
            pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
        }

        int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
        if(params.containsKey(PageUtil.PAGE_NUMBER)) {
            pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
        }

        BrandSpec brandSpec = new BrandSpec(brandFilter);

        Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);

        Page<Brand> page = brandRepository.findAll(brandSpec, pageable);
        return page;
    }


}
