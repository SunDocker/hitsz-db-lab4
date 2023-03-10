package cn.edu.hitsz.service.login;

import jakarta.servlet.annotation.WebServlet;

/**
 * @author SunDocker
 */
@WebServlet("/login/admin")
public class AdminLoginService extends LoginService {

    @Override
    String getUserTable() {
        return "admin";
    }

    @Override
    String getLoginErrPage() {
        return "/err/admin_login_err.html";
    }
}
