/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.ChainOfResponsibility;

public abstract class AbstractHandler implements ChainInterface {
    protected AbstractHandler nextHandler;

    public void execute(String request) {
        if (request.equals(this.getClass().getName())) {
            System.out.printf("%s %s\n", this.getClass().getName(), "has handle an error");
            return;
        }

        if (nextHandler == null) {
            throw new IllegalArgumentException(request + " does not exist in the chain");
        }

        nextHandler.execute(request);
    }

    /**
     * @param nextHandler
     * @return
     */
    public AbstractHandler setNext(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }
}
