package ru.sber.beautifulcode.parentheseschecker.service;

import ru.sber.beautifulcode.parentheseschecker.model.CheckRequest;
import ru.sber.beautifulcode.parentheseschecker.model.CheckResult;

public interface BracketsCheckService {
    CheckResult checkBrackets(CheckRequest checkRequest);
}
