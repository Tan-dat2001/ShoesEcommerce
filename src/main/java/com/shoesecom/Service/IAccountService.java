package com.shoesecom.Service;

import com.shoesecom.Model.Account;
import com.shoesecom.Model.Register;

import java.util.List;

public interface IAccountService {
    Boolean checkLogin(String email, String password);
    Account getAccountByEmail(String email);
    void sendEmail(Register register);
    void createAccount(Register register);
    void updateAccount(Account account);
    void updatePassword(Account account);
    List<Account> getAll();
    List<Account>getAccountbyID(int account_id);
    void changeStatusAccount(int account_id, String status);
}
