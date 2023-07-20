package com.makara.SystemPhone.mapper;

import com.makara.SystemPhone.dto.ModelDTO;
import com.makara.SystemPhone.entity.Brand;
import com.makara.SystemPhone.entity.Model;
import com.makara.SystemPhone.service.BrandService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = {BrandService.class})
public interface ModelMapper {
    ModelMapper  INSTANCE = Mappers.getMapper(ModelMapper.class);
    @Mapping(target = "brand",source = "brandId")
    Model toModel(ModelDTO dto);
    //This is concept java 8
 /*   default Brand toBrand(Integer brId){
          Brand brand = new Brand();
          brand.setId(brId);
          return brand;
    }*/
}
