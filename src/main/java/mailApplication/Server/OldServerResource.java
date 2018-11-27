package mailApplication.Server;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class OldServerResource extends ServerResource {

    @Get
    public String redirect() {
        System.out.println("XXXXX");
        redirectPermanent("http://localhost:8111/upload");
        System.out.println("Redirecting client to new location...");
        return "Resource moved...";
    }

}
