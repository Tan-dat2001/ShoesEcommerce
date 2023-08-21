package com.shoesecom.Service;

import com.shoesecom.Model.Account;
import com.shoesecom.Model.Register;

import java.util.List;

public interface IAccountService {
    Boolean checkLogin(String email, String password);
    Account getAccountByEmail(String email);
    void sendEmail(Register register);
    void createAccount(Register register);
    List<Account> getAll();
    List<Account>getAccountbyID(int account_id);
}
