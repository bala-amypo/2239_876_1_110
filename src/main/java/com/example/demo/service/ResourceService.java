package com.example.demo.service;

import com.example.demo.entity.Resource;
import com.example.demo.dto.ResourceRequestDto;
import java.util.List;

public interface ResourceService {

    List<Resource> getAllResources();

    // 🔥 REQUIRED BY CONTROLLER TEST
    Resource createResource(ResourceRequestDto dto);
}
