package cn.edu.hitsz.service.login;

/**
 * @author SunDocker
 */
public class AdminLoginService extends LoginService {
    public AdminLoginService() {
        userTable = "admin";
    }
}
