package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IAccountDAO;
import com.shoesecom.Model.Account;
import com.shoesecom.Model.Register;
import com.shoesecom.Service.IAccountService;

import javax.inject.Inject;
import java.util.List;

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

    @Override
    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    @Override
    public void updatePassword(Account account) {
        accountDAO.updatePassword(account);


    }

    @Override
    public List<Account> getAll() {
        return accountDAO.getAll();
    }

    @Override
    public List<Account> getAccountbyID(int account_id) {
        return accountDAO.getAccountbyID(account_id);
    }
}
