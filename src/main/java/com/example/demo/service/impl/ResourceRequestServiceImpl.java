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
        // Load user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        // Validate startTime and endTime
        if (request.getStartTime() == null || request.getEndTime() == null) {
            throw new ValidationException("Start time and end time are required");
        }
        if (request.getStartTime().isAfter(request.getEndTime())) {
            throw new ValidationException("Start time must be before end time");
        }

        // Validate purpose
        if (request.getPurpose() == null || request.getPurpose().isBlank()) {
            throw new ValidationException("Purpose is required");
        }

        // Set default status
        if (request.getStatus() == null || request.getStatus().isBlank()) {
            request.setStatus("PENDING");
        }

        request.setRequestedBy(user);
        return requestRepository.save(request);
    }

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        // Ensure user exists
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return requestRepository.findByRequestedById(userId);
    }

    @Override
    public ResourceRequest getRequest(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found with id: " + id));
    }

    @Override
    public ResourceRequest updateRequestStatus(Long requestId, String status) {
        ResourceRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found with id: " + requestId));

        if (status == null || status.isBlank()) {
            throw new ValidationException("Status cannot be empty");
        }

        request.setStatus(status.toUpperCase()); // Optional: normalize status
        return requestRepository.save(request);
    }
}
