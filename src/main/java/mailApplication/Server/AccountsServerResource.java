package mailApplication.Server;

import mailApplication.Common.AccountsResource;
import org.restlet.resource.ServerResource;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AccountsServerResource
        extends ServerResource
        implements AccountsResource {

    private static final List<String> accounts = new CopyOnWriteArrayList<>();

    static List<String> getAccounts() {
        return accounts;
    }

    public String add(String account) {
        getAccounts().add(account);
        return Integer.toString(getAccounts().size());
    }

    public String represent() {
        StringBuilder result = new StringBuilder();
        for (String account : getAccounts()) {
            result.append((account == null) ? "" : account).append("\n");
        }
        return result.toString();
    }

}
