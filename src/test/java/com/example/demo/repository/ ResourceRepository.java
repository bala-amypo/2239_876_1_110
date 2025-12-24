public interface ResourceRepository {
    boolean existsByResourceName(String name);
    List<Resource> findAll();
    List<Resource> findByResourceType(String type);
    Resource save(Resource r);
}
