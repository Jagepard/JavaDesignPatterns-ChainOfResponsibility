/**
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.ChainOfResponsibility;

public class ErrorHandler implements HandlerInterface {
    public void execute()
    {
        System.out.printf("%s\n", this.getClass().getName());
    }
}
