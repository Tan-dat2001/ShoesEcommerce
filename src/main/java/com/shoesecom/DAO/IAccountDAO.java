package com.shoesecom.DAO;

import com.shoesecom.Model.Account;
import com.shoesecom.Model.Register;

public interface IAccountDAO {
    boolean checkLogin(String email, String password);
    Account getAccountByEmail(String email);

    void crateAccount(Register register);
    void sendEmail(Register register);

}
