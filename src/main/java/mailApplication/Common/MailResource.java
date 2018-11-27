package mailApplication.Common;

import mailApplication.Server.MailModel;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface MailResource {

    @Get
    MailModel retrieve();

    @Put
    String store(MailModel mailModel) ;

}
