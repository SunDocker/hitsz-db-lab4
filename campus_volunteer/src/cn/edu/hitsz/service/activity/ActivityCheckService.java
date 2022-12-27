package cn.edu.hitsz.service.activity;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author SunDocker
 */
@WebServlet("/activity/check")
public class ActivityCheckService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String no = req.getParameter("no");


        PrintWriter out = resp.getWriter();
        resp.setContentType("text/txt");
        out.print("checkOK");
    }
}
