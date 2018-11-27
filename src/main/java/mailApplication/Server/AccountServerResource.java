package mailApplication.Server;

import mailApplication.Common.AccountResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.util.List;

public class AccountServerResource
        extends ServerResource
        implements AccountResource {

    private String accountId;
    private List<String> accountsList;

    @Override
    protected void doInit() throws ResourceException {
        this.accountId = getAttribute("accountId");
        accountsList = AccountsServerResource.getAccounts();
    }

    public String represent() {
        return accountsList.get(accountsList.indexOf(this.accountId));
    }

    public void store(String account) {
        accountsList.set(accountsList.indexOf(this.accountId), account);
    }

    public void remove() {
        accountsList.remove(accountsList.indexOf(this.accountId));
    }
}
