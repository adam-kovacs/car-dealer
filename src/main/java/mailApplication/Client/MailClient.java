package mailApplication.Client;

import org.restlet.data.*;
import org.restlet.resource.ClientResource;

public class MailClient {

    public static void main(String[] args) throws Exception {
        ClientResource clientResource = new ClientResource("http://localhost:8113");
//        ChallengeResponse authentication = new ChallengeResponse(
//                ChallengeScheme.HTTP_BASIC, "kuvasz", "password");
//        clientResource.setChallengeResponse(authentication);
        System.out.println(clientResource.get().getText());
    }

}
