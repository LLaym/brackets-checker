package ru.sber.beautifulcode.parentheseschecker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс, указывающий, является ли расстановка скобок правильной.
 *
 * @author Romanov Vitaly <vornysun@yandex.ru>
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class CheckResult {
    private Boolean isCorrect;
}
