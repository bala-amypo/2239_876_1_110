package com.example.demo.service;

import com.example.demo.entity.ResourceRequest;

public interface ResourceRequestService {
    ResourceRequest updateStatus(Long id, String status);
}
