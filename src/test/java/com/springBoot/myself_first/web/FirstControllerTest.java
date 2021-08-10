package com.springBoot.myself_first.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBoot.myself_first.service.GreetingService;
import com.springBoot.myself_first.web.dto.GreetingResponseDto;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@RunWith(SpringRunner.class)
public class FirstControllerTest {
     @Autowired
     private MockMvc mvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    public void 인사말() throws Exception{
        String greeting = "1.만나서 반갑습니다! 2.Hi!";

        mvc.perform(get("/api/greeting"))
                .andExpect(jsonPath("$.greeting", is(greeting)));
    }

    @Test
    public void 인사말_by_id() throws Exception{
        String greeting1 = "만나서 반갑습니다!";
        String greeting2 = "Hi!";

        when(greetingService.greetingById(1)).thenReturn(new GreetingResponseDto(greeting1));
        mvc.perform(get("/api/greeting/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.greeting", is(greeting1)));

        when(greetingService.greetingById(2)).thenReturn(new GreetingResponseDto(greeting2));
        mvc.perform(get("/api/greeting/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.greeting", is(greeting2)));
    }

    @Test
    public void 인사말_with_이름() throws Exception {
        when(greetingService.greetingWithName("jerry")).thenReturn(new GreetingResponseDto("WELCOME jerry"));

        mvc.perform(get("/api/greetingWithName").param("name", "jerry"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.greeting", is("WELCOME jerry")));
    }
}