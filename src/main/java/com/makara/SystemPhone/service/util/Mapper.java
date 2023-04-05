package com.makara.SystemPhone.service.util;

import com.makara.SystemPhone.dto.BrandDTO;
import com.makara.SystemPhone.entity.Brand;

public class Mapper {
    public static Brand toBrand(BrandDTO dto){
        Brand brand = new Brand();
       // brand.setId(dto.getId());
        brand.setName(dto.getName());
        return brand;
    }

    public static BrandDTO brandDTO(Brand brand){
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setName(brandDTO.getName());
        return brandDTO;
    }
}
