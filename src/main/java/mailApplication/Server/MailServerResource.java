package mailApplication.Server;

import mailApplication.Common.MailResource;
import org.restlet.data.Reference;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import java.util.Arrays;

public class MailServerResource
        extends ServerResource
        implements MailResource {

    @Get
    public MailModel retrieve() {
        MailModel mail = new MailModel();
        mail.setStatus("received");
        mail.setSubject("A lesson to learn, Kid");
        mail.setContent("Nobody exists on purpose, nobody belongs anywhere, everyone is gonna die. Come watch TV?");
        mail.setAccountRef(new Reference(getReference(), "..").getTargetRef().toString());
        System.out.println("username: " + getClientInfo().getUser().getName() + " || roles: " + Arrays.toString(getClientInfo().getRoles().toArray()));
        return mail;
    }

    @Put
    public String store (MailModel mailModel) {
        System.out.println("Subject: " + mailModel.getSubject());
        System.out.println("Content: " + mailModel.getContent());
        return "Mail Stored";
    }
}
