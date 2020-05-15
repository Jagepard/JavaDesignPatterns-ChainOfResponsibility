/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.ChainOfResponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainOfResponsibilityTest {
    private AbstractHandler chain;

    @BeforeEach
    void setUp() {
        this.chain = new NoticeHandler();
        this.chain.setNext(new WarningHandler()).setNext(new ErrorHandler());
    }

    @Test
    void testNoticeHandler() {
        assertEquals("Behavioral.ChainOfResponsibility.NoticeHandler has handle a request", this.chain.execute(NoticeHandler.class.getName()));
    }

    @Test
    void testWarningHandler() {
        assertEquals("Behavioral.ChainOfResponsibility.WarningHandler has handle a request", this.chain.execute(WarningHandler.class.getName()));
    }

    @Test
    void testErrorHandler() {
        assertEquals("Behavioral.ChainOfResponsibility.ErrorHandler has handle a request", this.chain.execute(ErrorHandler.class.getName()));
    }
}