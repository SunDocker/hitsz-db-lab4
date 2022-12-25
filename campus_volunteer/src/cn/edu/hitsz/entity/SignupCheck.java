package cn.edu.hitsz.entity;

/**
 * @author SunDocker
 */
public class SignupCheck {
    public String name;
    public String signupTime;
    public String checkStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignupTime() {
        return signupTime;
    }

    public void setSignupTime(String signupTime) {
        this.signupTime = signupTime;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }
}
