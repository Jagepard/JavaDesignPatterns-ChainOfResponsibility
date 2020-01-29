package Behavioral.ChainOfResponsibility;

public interface ChainInterface {
    void addToChain(HandlerInterface $handler);
    void execute(String handlerName);
}
