package com.shoesecom.DAO;

import com.shoesecom.Model.Account;
import com.shoesecom.Model.Register;

import java.util.List;

public interface IAccountDAO {
    boolean checkLogin(String email, String password);
    Account getAccountByEmail(String email);

    void crateAccount(Register register);
    void sendEmail(Register register);
    List<Account>getAll();
    List<Account>getAccountbyID(int account_id);
    void updateAccount(Account account);
    void updatePassword(Account account);



}
