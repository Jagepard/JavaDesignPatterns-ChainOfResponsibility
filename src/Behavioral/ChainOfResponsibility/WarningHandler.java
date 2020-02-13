/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.ChainOfResponsibility;

public class WarningHandler implements HandlerInterface {
    public void execute()
    {
        System.out.printf("%s\n", this.getClass().getName());
    }
}
