@Component
public class JwtUtil {

    private String secret;
    private int expiration;

    // REQUIRED by test case
    public JwtUtil(String secret, int expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // REQUIRED for Spring
    public JwtUtil() {
    }
}
