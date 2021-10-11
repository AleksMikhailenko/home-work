package com.sbrf.reboot.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import static org.owasp.encoder.Encode.forHtml;

@WebServlet("/reboot")
public class RebootServlet extends HttpServlet {

    private static final AtomicInteger counter = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        counter.getAndIncrement();
        String rawName = request.getParameter("name");
        response.setContentType("text/html");
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write(String.format("Hello %s<br>", rawName == null ? "" : forHtml(rawName)));
            printWriter.write(String.format("Counter = %s", counter));
        } catch (IOException e) {
            // some logic for handle error
        }
    }
}
