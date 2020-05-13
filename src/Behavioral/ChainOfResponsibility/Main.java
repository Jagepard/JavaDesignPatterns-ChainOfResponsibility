/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.ChainOfResponsibility;

public class Main {
    public static void main(String[] args) throws Exception {
        NoticeHandler notice   = new NoticeHandler();
        WarningHandler warning = new WarningHandler();
        ErrorHandler error     = new ErrorHandler();

        try {
            notice.setNext(warning).setNext(error);

            System.out.println(notice.execute(notice.getClass().getName()));
            System.out.println(notice.execute(warning.getClass().getName()));
            System.out.println(notice.execute(error.getClass().getName()));
        } catch (Exception e) {
            System.out.printf("Caught exception: %s \n", e.getLocalizedMessage());
        }
    }
}
