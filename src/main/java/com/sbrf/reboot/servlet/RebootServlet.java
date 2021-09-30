package com.sbrf.reboot.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/reboot")
public class RebootServlet extends HttpServlet {

    private static final AtomicInteger counter = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        counter.getAndIncrement();
        String name = request.getParameter("name");
        response.setContentType("text/html");
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write(String.format("Hello %s<br>", name == null ? "" : name));
            printWriter.write(String.format("Counter = %s", counter));
        } catch (IOException e) {
            // some logic for error
            e.printStackTrace();
        }
    }
}
