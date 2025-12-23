@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private ResourceRequestRepository resourceRequestRepository;
    private ResourceRepository resourceRepository;
    private ResourceAllocationRepository resourceAllocationRepository;

    // REQUIRED by test case
    public ResourceAllocationServiceImpl() {
    }

    @Autowired
    public ResourceAllocationServiceImpl(ResourceRequestRepository resourceRequestRepository,
                                         ResourceRepository resourceRepository,
                                         ResourceAllocationRepository resourceAllocationRepository) {
        this.resourceRequestRepository = resourceRequestRepository;
        this.resourceRepository = resourceRepository;
        this.resourceAllocationRepository = resourceAllocationRepository;
    }
}
