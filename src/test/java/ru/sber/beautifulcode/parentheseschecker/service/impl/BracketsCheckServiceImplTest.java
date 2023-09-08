package ru.sber.beautifulcode.parentheseschecker.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sber.beautifulcode.parentheseschecker.model.CheckRequest;
import ru.sber.beautifulcode.parentheseschecker.model.CheckResult;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BracketsCheckServiceImplTest {
    @InjectMocks
    private BracketsCheckServiceImpl parenthesesCheckService;

    @Test
    void checkBrackets_whenTextValid_thenTrueCheckResultReturned1() {
        CheckRequest request = new CheckRequest("Круто ((могло(а может нет) быть лучше(точно))). Все получится");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertTrue(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextValid_thenTrueCheckResultReturned2() {
        CheckRequest request = new CheckRequest("Молодец(умница), все круто! (это успех)");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertTrue(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextValid_thenTrueCheckResultReturned3() {
        CheckRequest request = new CheckRequest("(int) double - так делать неправильно!");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertTrue(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextValid_thenTrueCheckResultReturned4() {
        CheckRequest request = new CheckRequest("Добавим(может не надо?(надо)) больше (куда больше?) скобок!");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertTrue(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextValid_thenTrueCheckResultReturned5() {
        CheckRequest request = new CheckRequest("(это победа)");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertTrue(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextNotValid_thenFalseCheckResultReturned1() {
        CheckRequest request = new CheckRequest("Тут нет скобок. Где они? Такая строка не пройдет тест!");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertFalse(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextNotValid_thenFalseCheckResultReturned2() {
        CheckRequest request = new CheckRequest("()");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertFalse(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextNotValid_thenFalseCheckResultReturned3() {
        CheckRequest request = new CheckRequest("(");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertFalse(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextNotValid_thenFalseCheckResultReturned4() {
        CheckRequest request = new CheckRequest(")");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertFalse(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextNotValid_thenFalseCheckResultReturned5() {
        CheckRequest request = new CheckRequest("");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertFalse(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextNotValid_thenFalseCheckResultReturned6() {
        CheckRequest request = new CheckRequest("Кто так ставит скобки?(");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertFalse(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextNotValid_thenFalseCheckResultReturned7() {
        CheckRequest request = new CheckRequest(")Кто так ставит скобки?");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertFalse(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextNotValid_thenFalseCheckResultReturned8() {
        CheckRequest request = new CheckRequest(")Кто так ставит скобки?(");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertFalse(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextNotValid_thenFalseCheckResultReturned9() {
        CheckRequest request = new CheckRequest("()Кто так ставит скобки?");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertFalse(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextNotValid_thenFalseCheckResultReturned10() {
        CheckRequest request = new CheckRequest("Кто так () ставит скобки?");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertFalse(result.getIsCorrect());
    }

    @Test
    void checkBrackets_whenTextNotValid_thenFalseCheckResultReturned11() {
        CheckRequest request = new CheckRequest("Кто так ставит скобки?()");

        CheckResult result = parenthesesCheckService.checkBrackets(request);

        assertNotNull(result);
        assertFalse(result.getIsCorrect());
    }
}