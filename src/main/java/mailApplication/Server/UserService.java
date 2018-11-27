package mailApplication.Server;

import org.restlet.security.MemoryRealm;

public class UserService extends MemoryRealm {
    private static UserService instance = null;
    private MemoryRealm realm;

    private UserService() {
        this.realm = new MemoryRealm();
        this.realm.setName("MailRealm");
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
           instance = new UserService();
        }
        return instance;
    }
}
