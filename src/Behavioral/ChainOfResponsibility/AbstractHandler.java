/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.ChainOfResponsibility;

public abstract class AbstractHandler implements ChainInterface {
    protected AbstractHandler nextHandler;

    public String execute(String request) {
        if (request.equals(this.getClass().getName())) {
            return String.format("%s %s", this.getClass().getName(), "has handle a request");
        }

        if (nextHandler == null) {
            throw new IllegalArgumentException(request + " does not exist in the chain");
        }

        return nextHandler.execute(request);
    }

    public AbstractHandler setNext(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }
}
