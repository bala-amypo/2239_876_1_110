package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ResourceRequestService;
import java.util.List;

public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository repo;
    private final UserRepository userRepo;

    public ResourceRequestServiceImpl(ResourceRequestRepository r, UserRepository u) {
        this.repo = r;
        this.userRepo = u;
    }

    public ResourceRequest createRequest(Long userId, ResourceRequest req) {
        User u = userRepo.findById(userId).orElseThrow();
        req.setRequestedBy(u);
        req.setStatus("PENDING");
        return repo.save(req);
    }

    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return repo.findByRequestedBy_Id(userId);
    }

    public ResourceRequest updateRequestStatus(Long id, String status) {
        ResourceRequest r = repo.findById(id).orElseThrow();
        r.setStatus(status);
        return repo.save(r);
    }
}
