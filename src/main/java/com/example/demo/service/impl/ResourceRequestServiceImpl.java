package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ResourceRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    @Autowired
    private ResourceRequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResourceRequest createRequest(Long userId, ResourceRequest request) {
        // Load User
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        request.setRequestedBy(user);

        // Validate startTime and endTime
        if (request.getStartTime() == null || request.getEndTime() == null || 
            !request.getStartTime().isBefore(request.getEndTime())) {
            throw new ValidationException("Start time must be before end time.");
        }

        // Validate purpose
        if (request.getPurpose() == null || request.getPurpose().trim().isEmpty()) {
            throw new ValidationException("Purpose must be provided.");
        }

        // Set default status
        if (request.getStatus() == null || request.getStatus().trim().isEmpty()) {
            request.setStatus("PENDING");
        }

        return requestRepository.save(request);
    }

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        // Optional: Validate user existence
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id " + userId);
        }
        return requestRepository.findByRequestedById(userId);
    }

    @Override
    public ResourceRequest getRequest(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource request not found with id " + id));
    }

    @Override
    public ResourceRequest updateRequestStatus(Long requestId, String status) {
        ResourceRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource request not found with id " + requestId));

        request.setStatus(status);
        return requestRepository.save(request);
    }
}
