/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.ChainOfResponsibility;

import java.util.Map;
import java.util.LinkedHashMap;

public class Chain implements ChainInterface {
    LinkedHashMap <String, HandlerInterface> chain = new LinkedHashMap<>();

    public void addToChain(HandlerInterface handler)
    {
        String handlerName = handler.getClass().getName();

        if (chain.containsKey(handlerName)) {
            throw new IllegalArgumentException("Handler already exists");
        }

        chain.put(handlerName, handler);
    }

    public void execute(String handlerName)
    {
        if (this.chain.isEmpty()) {
            throw new IllegalArgumentException("The chain is empty");
        }

        if (chain.containsKey(handlerName)) {
            for(Map.Entry<String, HandlerInterface> entry : chain.entrySet()) {
                HandlerInterface handler = entry.getValue();

                handler.execute();
                
                if (handlerName.equals(handler.getClass().getName())) {
                    System.out.print("\n");
                    return;
                }
            }
        }

        throw new IllegalArgumentException("Handler does not exist in the chain");
    }
}
