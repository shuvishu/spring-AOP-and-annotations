package aop;

import org.springframework.stereotype.Component;


@Component
public class demo {

    public void display()
    {
        System.out.println("Inside class demo's display method");
    }

    public void show()
    {
        System.out.println("Inside class demo's show method");
    }
}
