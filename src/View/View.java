package View;

public class View {
    private AccountList aList;
    private ExistingAccount eAccount;
    private NewAccount nAccount;
    
    /**
     * Default constructor for a view
     */
    public View()
    {
        //Initialize all the new GUI bits
        aList = new AccountList();
        eAccount = new ExistingAccount();
        nAccount = new NewAccount();
    }

    /**
     * Allow access to the AccountList GUI
     * @return An AccountList that can be modified
     */
    public AccountList getAccountList() {
        return aList;
    }

    /**
     * Allow access to the ExistingAccount GUI
     * @return An ExistingAccount that can be modified
     */

    public ExistingAccount getExistingAccount() {
        return eAccount;
    }

    /**
     * Allow access to the NewAccount GUI
     * @return An NewAccount that can be modified
     */

    public NewAccount getNewAccount() {
        return nAccount;
    }
    
    
}
