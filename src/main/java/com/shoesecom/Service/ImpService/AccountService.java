package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IAccountDAO;
import com.shoesecom.Model.Account;
import com.shoesecom.Model.Register;
import com.shoesecom.Service.IAccountService;

import javax.inject.Inject;

public class AccountService implements IAccountService {
    @Inject
    private IAccountDAO accountDAO;
    @Override
    public Boolean checkLogin(String email, String password) {
        return accountDAO.checkLogin(email,password);
    }

    @Override
    public Account getAccountByEmail(String email) {
        return accountDAO.getAccountByEmail(email);
    }

    @Override
    public void sendEmail(Register register) {
        accountDAO.sendEmail(register);
    }

    @Override
    public void createAccount(Register register) {
        accountDAO.crateAccount(register);

    }
}
