@Service
public class ResourceAllocationService {

    @Autowired
    private ResourceRequestRepository requestRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceAllocationRepository allocationRepository;

    public ResourceAllocation autoAllocate(Long requestId) {

        ResourceRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));

        if (!"PENDING".equals(request.getStatus())) {
            throw new IllegalArgumentException("Request is not pending");
        }

        Resource resource = resourceRepository
                .findFirstByResourceType(request.getResourceType())
                .orElseThrow(() -> new IllegalArgumentException("No resource available"));

        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setRequest(request);
        allocation.setResource(resource);
        allocation.setAllocatedAt(LocalDateTime.now());
        allocation.setConflictFlag(false);

        request.setStatus("ALLOCATED");

        return allocationRepository.save(allocation);
    }
}
