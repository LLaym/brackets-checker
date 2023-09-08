package ru.sber.beautifulcode.parentheseschecker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.sber.beautifulcode.parentheseschecker.model.CheckRequest;
import ru.sber.beautifulcode.parentheseschecker.model.CheckResult;
import ru.sber.beautifulcode.parentheseschecker.service.BracketsCheckService;

import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = BracketsCheckController.class)
@ExtendWith(MockitoExtension.class)
class BracketsCheckControllerTest {
    @Autowired
    ObjectMapper mapper;
    @MockBean
    private BracketsCheckService bracketsCheckService;
    @Autowired
    private MockMvc mvc;
    private CheckResult expectedResult;

    @BeforeEach
    void prepareData() {
        expectedResult = new CheckResult(true);
    }

    @Test
    void checkBrackets_whenTextNotEmpty_thenResponseStatusOkWithCheckResultInBody() throws Exception {
        CheckRequest request = new CheckRequest("Тут есть(точно), что нужно проверить");

        when(bracketsCheckService.checkBrackets(any(CheckRequest.class)))
                .thenReturn(expectedResult);

        mvc.perform(post("/api/checkBrackets", request)
                        .content(mapper.writeValueAsString(request))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));

        verify(bracketsCheckService, times(1)).checkBrackets(any(CheckRequest.class));
        verifyNoMoreInteractions(bracketsCheckService);
    }

    @Test
    void checkBrackets_whenTextEmpty_thenResponseClientError() throws Exception {
        CheckRequest request = new CheckRequest("");

        mvc.perform(post("/api/checkBrackets", request)
                        .content(mapper.writeValueAsString(request))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());

        verifyNoInteractions(bracketsCheckService);
    }
}