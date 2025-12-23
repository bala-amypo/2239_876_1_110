@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    private ResourceRequestRepository resourceRequestRepository;
    private UserRepository userRepository;

    // REQUIRED by test case
    public ResourceRequestServiceImpl() {
    }

    @Autowired
    public ResourceRequestServiceImpl(ResourceRequestRepository resourceRequestRepository,
                                      UserRepository userRepository) {
        this.resourceRequestRepository = resourceRequestRepository;
        this.userRepository = userRepository;
    }
}
