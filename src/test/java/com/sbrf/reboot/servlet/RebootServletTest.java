package com.sbrf.reboot.servlet;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RebootServletTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private RebootServlet servlet;
    private StringWriter sw;
    private PrintWriter pw;

    @BeforeEach
    void setUp() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        servlet = new RebootServlet();
        sw = new StringWriter();
        pw = new PrintWriter(sw);
    }

    @SneakyThrows
    @Test
    void testResponseWithParameter() {

        when(request.getParameter("name")).thenReturn("Jake");
        when(response.getWriter()).thenReturn(pw);

        servlet.doGet(request, response);
        String result = sw.toString().trim();

        assertEquals("Hello Jake<br>Counter = 1", result);
    }

    @SneakyThrows
    @Test
    void testResponseWithoutParameter() {

        when(request.getParameter("name")).thenReturn(null);
        when(response.getWriter()).thenReturn(pw);

        servlet.doGet(request, response);
        String result = sw.toString().trim();

        assertEquals("Hello <br>Counter = 2", result);
    }
}