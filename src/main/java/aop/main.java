package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class main {
    public static void main(String[] args) throws IOException {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        demo obj1=applicationContext.getBean(demo.class);

        //Question 1
        obj1.display();
        obj1.show();

        //Question 2
        ques2 obj2= applicationContext.getBean(ques2.class);
        obj2.print();

        //Question 3
        ques3 obj3=applicationContext.getBean(ques3.class);

        /*try {
            obj3.add();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //Question 4

        ques4 obj4=applicationContext.getBean(ques4.class);
        obj4.database();

        //Question 5
        ques5 obj5 = applicationContext.getBean(ques5.class);
        obj5.showcase();

        //Question 6

        ques6 obj6= applicationContext.getBean(ques6.class);
        obj6.displaymethod();

        //Question 7
        ques7 obj7= applicationContext.getBean(ques7.class);
        obj7.displaynew(2,"ques7 method");

    }
}
