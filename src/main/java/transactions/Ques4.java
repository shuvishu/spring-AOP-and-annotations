package transactions;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;


@Transactional
@Component
public class Ques4 {

    private Account account;
   private AccountService accountService;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = SQLException.class)
    void transactAmount(String senderName , String recieverName,double amount)
    {
        User sender = account.getData(senderName);
        User reciever = account.getData(recieverName);
        if(checkBalance(sender.getBalance(),amount))
        {
            account.update(senderName,sender.getBalance()-amount);
            account.update(recieverName,reciever.getBalance()+amount);
            accountService.updateTable(senderName,recieverName,amount);
            System.out.println(" Balance Updated!!");
        }
        else
        {
            System.out.println("Insufficient Balance!!");
        }
    }

    private boolean checkBalance(double initial , double todeduct)
    {
        if(initial>todeduct)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
