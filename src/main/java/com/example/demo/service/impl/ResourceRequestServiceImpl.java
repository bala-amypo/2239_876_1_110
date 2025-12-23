package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ResourceRequestService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    @Autowired
    private ResourceRequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResourceRequest createRequest(Long userId, ResourceRequest request) {
        request.setRequestedBy(userRepository.findById(userId).orElse(null));
        request.setStatus("PENDING");
        return requestRepository.save(request);
    }

    @Override
    public List<ResourceRequest> getRequests(Long userId) {
        return requestRepository.findByRequestedBy_Id(userId);
    }

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return requestRepository.findByRequestedBy_Id(userId);
    }

    @Override
    public ResourceRequest updateRequestStatus(Long requestId, String status) {
        ResourceRequest r = requestRepository.findById(requestId).orElse(null);
        r.setStatus(status);
        return requestRepository.save(r);
    }
}
