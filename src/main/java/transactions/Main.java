package transactions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {


        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("tx-config.xml");

        //Question 2
        Account account=(Account) applicationContext.getBean(Account.class);
        User user=new User("Alex", 25000.0);
        User user1 = new User("Jason", 35000.0);
        account.add(user);
        account.add(user1);
        account.update("Jason", 30000.0);
        //System.out.println(user2);
        account.delete("Alex");

        //Question 3
        AccountQ3 accountQ3=(AccountQ3) applicationContext.getBean(AccountQ3.class);
        User q3user1 = new User("Ana", 15550);
        User q3user2 =new User("Kate",16500);
        accountQ3.addUser(q3user1);
        accountQ3.addUser(q3user2);
        User q3user3= accountQ3.getData("Kate");
        System.out.println(q3user3);

        //Question 4 & 6

        Ques4 ques4=(Ques4) applicationContext.getBean(Ques4.class);
        ques4.transactAmount("Ana","Kate",5000);
    }
}
