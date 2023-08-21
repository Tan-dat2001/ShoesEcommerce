package com.shoesecom.Service;

import com.shoesecom.Model.Account;
import com.shoesecom.Model.Register;

public interface IAccountService {
    Boolean checkLogin(String email, String password);
    Account getAccountByEmail(String email);
    void sendEmail(Register register);
    void createAccount(Register register);
}
