package mailApplication.Server;

import org.restlet.security.SecretVerifier;
import org.restlet.security.User;

import java.util.Arrays;

public class UserVerifier extends SecretVerifier {

    private UserService userService = UserService.getInstance();

    public UserVerifier() {
    }

    @Override
    public int verify(String userId, char[] password) {
        for (User user : userService.getUsers()) {
            if (user.getIdentifier().equals(userId)) {
                if (Arrays.equals(user.getSecret(), password)) {
                    return RESULT_VALID;
                }
            }
        }
        return  RESULT_INVALID;
    }

}
