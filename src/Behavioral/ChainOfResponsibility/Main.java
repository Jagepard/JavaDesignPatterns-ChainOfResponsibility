/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.ChainOfResponsibility;

public class Main {
    public static void main(String[] args) throws Exception {
        AbstractHandler chain  = new NoticeHandler();
        AbstractHandler warning = new WarningHandler();
        AbstractHandler error = new ErrorHandler();

        try {
            chain.setNext(warning).setNext(error);
            chain.execute(chain.getClass().getName());
            chain.execute(warning.getClass().getName());
            chain.execute(error.getClass().getName());
        } catch (Exception e) {
            System.out.printf("Caught exception: %s \n", e.getLocalizedMessage());
        }
    }
}
