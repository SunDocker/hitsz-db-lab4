package cn.edu.hitsz.service.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author SunDocker
 */
@WebServlet("/volLogin")
public class VolLoginService extends LoginService {
    public VolLoginService() {
        userTable = "volunteer";
    }
}
