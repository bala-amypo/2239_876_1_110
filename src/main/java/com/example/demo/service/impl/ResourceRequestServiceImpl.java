package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import org.springframework.stereotype.Service;

@Service
public class ResourceRequestServiceImpl {

    public ResourceRequestServiceImpl() {
    }

    public void updateStatus(ResourceRequest request, String status) {
        request.setStatus(status);
    }
}
