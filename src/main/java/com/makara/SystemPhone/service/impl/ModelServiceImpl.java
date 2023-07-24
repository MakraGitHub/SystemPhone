package com.makara.SystemPhone.service.impl;

import com.makara.SystemPhone.dto.ModelDTO;
import com.makara.SystemPhone.entity.Model;
import com.makara.SystemPhone.mapper.ModelMapper;
import com.makara.SystemPhone.repository.ModelRepository;
import com.makara.SystemPhone.service.BrandService;
import com.makara.SystemPhone.service.ModelService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
     private final ModelRepository modelRepository;
     private final ModelMapper modelMapper;
    @Override
    public Model save(ModelDTO dto) {
        Model model = modelMapper.toModel(dto);
        return modelRepository.save(model);
    }
}
