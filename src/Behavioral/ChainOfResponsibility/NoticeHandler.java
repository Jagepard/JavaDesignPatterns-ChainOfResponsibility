package Behavioral.ChainOfResponsibility;

public class NoticeHandler implements HandlerInterface {
    public void execute()
    {
        System.out.printf("%s\n", this.getClass().getName());
    }
}
