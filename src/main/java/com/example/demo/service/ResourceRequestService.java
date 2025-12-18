package com.example.demo.service;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceRequestService {

    private final ResourceRequestRepository requestRepository;
    private final UserRepository userRepository;

    // ⚠️ Constructor order EXACT
    public ResourceRequestService(ResourceRequestRepository requestRepository,
                                  UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
    }

    public ResourceRequest createRequest(Long userId, ResourceRequest request) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new ValidationException("user not exists");
        }
        if (request.getStartTime().isAfter(request.getEndTime())) {
            throw new ValidationException("start time must be before end time");
        }
        if (request.getPurpose() == null) {
            throw new ValidationException("purpose required");
        }
        request.setRequestedBy(user);
        request.setStatus("PENDING");
        return requestRepository.save(request);
    }

    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return requestRepository.findByRequestedBy_Id(userId);
    }

    public ResourceRequest getRequest(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    public ResourceRequest updateRequestStatus(Long requestId, String status) {
        ResourceRequest request = getRequest(requestId);
        if (request != null) {
            request.setStatus(status);
            return requestRepository.save(request);
        }
        return null;
    }
}
