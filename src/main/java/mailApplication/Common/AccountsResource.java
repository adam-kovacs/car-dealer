package mailApplication.Common;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface AccountsResource {

    @Get("json")
    public String represent();

    @Post("txt")
    public String add(String account);
}
