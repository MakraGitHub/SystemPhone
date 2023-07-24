package com.makara.SystemPhone.controller;

import com.makara.SystemPhone.dto.ModelDTO;
import com.makara.SystemPhone.entity.Model;
import com.makara.SystemPhone.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
        Model model = modelService.save(modelDTO);
        return ResponseEntity.ok(model);
    }

}
