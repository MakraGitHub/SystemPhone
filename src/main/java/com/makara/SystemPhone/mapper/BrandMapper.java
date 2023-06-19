package com.makara.SystemPhone.mapper;

import com.makara.SystemPhone.dto.BrandDTO;
import com.makara.SystemPhone.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
    Brand toBrand(BrandDTO dto);

    BrandDTO toBrandDTO(Brand entity);

}
