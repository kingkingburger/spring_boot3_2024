package hello.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("TestServlet.service");
        resp.getWriter().println("test");
    }
}
