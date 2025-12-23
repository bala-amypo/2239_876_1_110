@Service
public class ResourceServiceImpl implements ResourceService {

    private ResourceRepository resourceRepository;

    // REQUIRED by test case
    public ResourceServiceImpl() {
    }

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }
}
