package com.shoesecom.DAO;

import com.shoesecom.Model.Account;

public interface IAccountDAO {
    boolean checkLogin(String email, String password);
    Account getAccountByEmail(String email);

}
