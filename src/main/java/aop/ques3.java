package aop;

import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ques3 {

    public void add() throws IOException {
        System.out.println("Ques3 add method");
        throw new IOException();
    }

}
