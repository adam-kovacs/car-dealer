package mailApplication.Server;

import mailApplication.Common.RootResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class RootServerResource
        extends ServerResource
        implements RootResource {

    public String represent() throws ResourceException {
        return "Welcome to " + getApplication().getName() + "!";
    }

}
