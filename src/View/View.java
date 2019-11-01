package View;

public class View {
    private AccountList aList;
    private ExistingAccount eAccount;
    private NewAccount nAccount;
    
    public View()
    {
        aList = new AccountList();
        eAccount = new ExistingAccount();
        nAccount = new NewAccount();
    }

    public AccountList getAccountList() {
        return aList;
    }

    public ExistingAccount getExistingAccount() {
        return eAccount;
    }

    public NewAccount getNewAccount() {
        return nAccount;
    }
    
    
}
