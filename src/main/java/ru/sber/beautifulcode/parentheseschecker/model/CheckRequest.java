package ru.sber.beautifulcode.parentheseschecker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Класс, представляющий собой входящий запрос с текстом, который нужно проверить.
 *
 * @author Romanov Vitaly <vornysun@yandex.ru>
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckRequest {
    @NotBlank(message = "Text must not be blank")
    private String text;
}
