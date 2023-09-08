package ru.sber.beautifulcode.parentheseschecker.service.impl;

import org.springframework.stereotype.Service;
import ru.sber.beautifulcode.parentheseschecker.model.CheckRequest;
import ru.sber.beautifulcode.parentheseschecker.model.CheckResult;
import ru.sber.beautifulcode.parentheseschecker.service.BracketsCheckService;

@Service
public class BracketsCheckServiceImpl implements BracketsCheckService {

    /**
     * Метод проверяет расстановку скобок в тексте. Внутри себя вызывает приватный метод,
     * который проверяет, является ли скобочная последовательность в тексте правильной.
     *
     * @param checkRequest запрос от пользователя, содержащий текст для проверки
     * @return объект CheckResult, указывающий, является ли расстановка скобок правильной
     */
    @Override
    public CheckResult checkBrackets(CheckRequest checkRequest) {
        String text = checkRequest.getText();

        // Если длина текста меньше 2, то проверять нет смысла, возвращаем false
        if (text.length() < 2) {
            return new CheckResult(false);
        }

        return isValidBrackets(text) ? new CheckResult(true) : new CheckResult(false);
    }

    /**
     * Метод проверяет, является ли скобочная последовательность в тексте правильной.
     *
     * @param text проверяемый текст
     * @return true если скобочная последовательность правильная и false если нет
     */
    private boolean isValidBrackets(String text) {
        int openParenthesesCount = 0;
        boolean hasTextInsideParentheses = false;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar == '(') {
                openParenthesesCount++;
            } else if (currentChar == ')') {
                if (openParenthesesCount == 0 || !hasTextInsideParentheses) return false;
                openParenthesesCount--;
            } else if (openParenthesesCount > 0) {
                hasTextInsideParentheses = true;
            }
        }

        return openParenthesesCount == 0 && hasTextInsideParentheses;
    }
}