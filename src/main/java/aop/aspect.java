package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;


@Aspect
public class aspect {

    //Ques 1
    @Before("execution(* aop.demo.*())")
    void beforeadvice()
    {
        System.out.println("Logging display methods");
    }

    //Ques 2
    @Before("execution(void aop.ques2.print())")
    void before()
    {
        System.out.println("Before ques 2 print method");
    }

    @After("execution(void aop.ques2.print())")
    void after()
    {
        System.out.println("After ques2 print method");
    }

    //Ques 3
    @AfterThrowing(pointcut = "execution(void aop.ques3.add())")
    void exceptn()
    {
        System.out.println("Exception method called at exception in ques3 class");
    }

    //Ques 4
    @Before("@annotation(Deprecated)")
    void view()
    {
        System.out.println("Method call before deprecated method's call");

    }

    //Question 5
    //execution
    @Before("execution(void aop.ques5.showcase())")
    void aspectmethod()
    {
        System.out.println("execution method before ques 5 class's showcase method! ");
    }

    @After("execution(void aop.ques5.showcase())")
    void aspectmethod1()
    {
        System.out.println("execution after before ques 5 class's showcase method! ");
    }

    //within
    @Before("within(aop.ques5)")
    void printing()
    {
        System.out.println("logging before ques5 showcase method using within");
    }

    @After("within(aop.ques5)")
    void printing1()
    {
        System.out.println("logging after ques5 showcase method using within");
    }

    //args
    @Before("args(Integer)")
    void call()
    {
        System.out.println("logging before ques5 showcase method using args");
    }

    @After("args(Integer)")
    void call1()
    {
        System.out.println("logging after ques5 showcase method using args");
    }

    //this
    @Before("this(aop.ques5)")
    void subs()
    {
        System.out.println("logging before ques5 showcase method using this!");
    }
    @After("this(aop.ques5)")
    void dels()
    {
        System.out.println("logging after ques5 showcase method using this!");
    }

    @Before("bean(ques5))")
    void printing2()
    {
        System.out.println("logging before ques5 showcase method using bean");
    }
    @After("bean(ques5))")
    void printing3()
    {
        System.out.println("logging after ques5 showcase method using bean");
    }

    //Question 6
    @Before("executePointcut()")
    void invoke()
    {
        System.out.println("\n logging before ques 6 displaymethod by poincut");
    }

    @Pointcut("execution(void aop.ques6.displaymethod())")
    void executePointcut(){}

    //Question7
    @Before("execution(void aop.ques7.displaynew(..))")
    void invokeques7(JoinPoint joinPoint){
        System.out.println("\n logging before displaynew method of ques7 class");
        System.out.println("\n displaynew signature: "+joinPoint.getSignature());

        System.out.println("\n Arguments : ");
        Object[] objects= joinPoint.getArgs();

        for (Object o: objects) {
            System.out.println("\n Arguments are: "+o);
        }
    }

}
