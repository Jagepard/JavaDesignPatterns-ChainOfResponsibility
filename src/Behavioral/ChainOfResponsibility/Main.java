package Behavioral.ChainOfResponsibility;

public class Main {
    public static void main(String[] args) throws Exception {
        ChainInterface chain = new Chain();
        HandlerInterface notice = new NoticeHandler();
        HandlerInterface warning = new WarningHandler();
        HandlerInterface error = new ErrorHandler();

        try {
            chain.addToChain(notice);
            chain.addToChain(warning);
            chain.addToChain(error);
            chain.execute(notice.getClass().getName());
            chain.execute(warning.getClass().getName());
            chain.execute(error.getClass().getName());
        } catch (Exception e) {
            System.out.printf("Caught exception: %s \n", e.getLocalizedMessage());
        }
    }
}
