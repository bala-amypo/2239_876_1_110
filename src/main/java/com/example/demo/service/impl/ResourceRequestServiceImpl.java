package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    @Autowired
    private ResourceRequestRepository reqRepo;

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        // ✅ FIXED call
        return reqRepo.findByRequestedById(userId);
    }
}
