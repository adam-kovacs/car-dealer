package mailApplication;

import mailApplication.Server.*;
import org.restlet.*;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.RoleAuthorizer;

public class MailServerApp extends Application {

    MailServerApp() {
        setName("KuvaszMail");
        setDescription("A RESTful e-mail app, powered by Restlet");
        setOwner("Onbox");
        setAuthor("Kuvasz");
    }

    @Override
    public final Restlet createInboundRoot(){
        Context context = getContext();

        Router router = new Router(context);
        String rootUri = "file:///" + System.getProperty("user.home");

        Directory directory = new Directory(getContext(), rootUri);
        directory.setListingAllowed(true);

        router.attach("/", RootServerResource.class);
        router.attach("/accounts/", AccountsServerResource.class);
        router.attach("/accounts/{accountId}", AccountServerResource.class);
        router.attach("/accounts/{accountId}/mails/{mailId}", MailServerResource.class);
        router.attach("/home/", directory);
        router.attach("/upload/", FileUploadServerResource.class);

        RoleAuthorizer authorizer = new RoleAuthorizer();
        authorizer.getAuthorizedRoles().add(getRole("CEO"));
        authorizer.getForbiddenRoles().add(getRole("Admin"));
        authorizer.setNext(router);

        ChallengeAuthenticator authenticator = new ChallengeAuthenticator(context, ChallengeScheme.HTTP_BASIC, "MailRealm");
        authenticator.setVerifier(getContext().getDefaultVerifier());
        authenticator.setNext(authorizer);

        return authenticator;
    }

}
