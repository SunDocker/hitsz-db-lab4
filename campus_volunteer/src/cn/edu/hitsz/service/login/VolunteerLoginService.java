package cn.edu.hitsz.service.login;

import jakarta.servlet.annotation.WebServlet;

/**
 * @author SunDocker
 */
@WebServlet("/login/volunteer")
public class VolunteerLoginService extends LoginService {

    @Override
    String getUserTable() {
        return "volunteer";
    }

    @Override
    String getLoginErrPage() {
        return "/err/volunteer_login_err.html";
    }
}
