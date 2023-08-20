package com.shoesecom.Service;

import com.shoesecom.Model.Account;

public interface IAccountService {
    Boolean checkLogin(String email, String password);
    Account getAccountByEmail(String email);
}
