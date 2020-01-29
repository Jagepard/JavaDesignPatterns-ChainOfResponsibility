/**
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.ChainOfResponsibility;

import java.util.Map;
import java.util.LinkedHashMap;

public class Chain implements ChainInterface {
    private LinkedHashMap <String, HandlerInterface> chain = new LinkedHashMap<String, HandlerInterface>();

    public void addToChain(HandlerInterface handler)
    {
        String handlerName = handler.getClass().getName();

        if (chain.containsKey(handlerName)) {
            throw new IllegalArgumentException();
        }

        chain.put(handlerName, handler);
    }

    public void execute(String handlerName)
    {
        if (this.chain.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (chain.containsKey(handlerName)) {
            for(Map.Entry<String, HandlerInterface> entry : chain.entrySet()) {
                HandlerInterface handler = entry.getValue();

                handler.execute();
                
                if (handler.getClass().getName() == handlerName) {
                    return;
                }
            }
        }

        throw new IllegalArgumentException();
    }
}
