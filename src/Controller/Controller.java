package Controller;

import Model.Model;
import View.View;

public class Controller {
    /**
     * The controller glues the controllers to the panels making them work
     * @param m The model to be observed
     * @param v The views that need to observe the model
     */
    public Controller(Model m, View v)
    {
        AccountListController aControl = new AccountListController(m, v.getAccountList());
        //ExistingAccountController eControl = new ExistingAccountController(m, v.getExistingAccount());
        NewAccountController nControl = new NewAccountController(m, v.getNewAccount());
    }
}
