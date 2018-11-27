package mailApplication;

import mailApplication.Server.OldServerResource;
import mailApplication.Server.UserService;
import mailApplication.Server.UserVerifier;
import org.jetbrains.annotations.NotNull;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.security.Role;
import org.restlet.security.User;

public class MailServerComponent extends Component {

    private UserService userService = UserService.getInstance();

    public static void main(String[] args) throws Exception {
        new MailServerComponent().start();
    }

    private MailServerComponent() {
        setName("MailModel Server Component");
        setDescription("RESTful mail component");
        setAuthor("Kuvasz");
        setOwner("Onbox");

        getClients().add(Protocol.FILE);

        Server server = getServers().add(Protocol.HTTP, 8111);
        Server oldServer = getServers().add(Protocol.HTTP, 8113);
        server.getContext().getParameters().set("tracing", "true");
        oldServer.getContext().getParameters().set("tracing", "true");

        MailServerApp app = new MailServerApp();
        getDefaultHost().attachDefault(app);
        userService.setVerifier(new UserVerifier());
        oldServer.setNext(OldServerResource.class);

        app.getRoles().add(new Role(app, "CEO", "Lead of mail company"));
        app.getRoles().add(new Role(app, "User", "Regular user"));
        app.getRoles().add(new Role(app, "Admin", "Administrator user"));
        app.getContext().setDefaultEnroler(userService.getEnroler());
        app.getContext().setDefaultVerifier(userService.getVerifier());

        initUsers(app);

    }

    private void initUsers(@NotNull Application app) {

        User kuvasz = new User("kuvasz", "password",
                "Kovács", "Ádám", "kuvaszka@gmail.com");
        userService.getUsers().add(kuvasz);
        userService.map(kuvasz, app.getRole("CEO"));
        userService.map(kuvasz, app.getRole("User"));

        User eszti = new User("eszti", "pwd",
                "Zrinyifalvi", "Eszter", "zreszter@gmail.com");
        userService.getUsers().add(eszti);
        userService.map(eszti, app.getRole("User"));

        User gero = new User("gero", "jelszo",
                "Kovács", "Gerő", "kksmg@gmail.com");
        userService.getUsers().add(gero);
        userService.map(gero, app.getRole("Admin"));
    }

}
