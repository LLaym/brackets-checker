package ru.sber.beautifulcode.parentheseschecker.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.beautifulcode.parentheseschecker.model.CheckRequest;
import ru.sber.beautifulcode.parentheseschecker.model.CheckResult;
import ru.sber.beautifulcode.parentheseschecker.service.BracketsCheckService;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BracketsCheckController {
    private final BracketsCheckService service;

    @PostMapping("/api/checkBrackets")
    public CheckResult checkBrackets(@RequestBody @Valid CheckRequest checkRequest) {
        log.info("Received POST request with body: {}", checkRequest);
        return service.checkBrackets(checkRequest);
    }
}
