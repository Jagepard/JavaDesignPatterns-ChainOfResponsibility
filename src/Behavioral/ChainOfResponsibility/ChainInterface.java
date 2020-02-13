/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.ChainOfResponsibility;

public interface ChainInterface {
    void addToChain(HandlerInterface handler);
    void execute(String handlerName);
}
