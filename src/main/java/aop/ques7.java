package aop;

import org.springframework.stereotype.Component;


@Component
public class ques7 {

    public void displaynew(int id , String name)
    {
        System.out.println("\nIn displaynew method with id: "+id +" name: "+name);

    }
}
