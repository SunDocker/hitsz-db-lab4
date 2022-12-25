package cn.edu.hitsz.entity;

/**
 * @author SunDocker
 */
public class AdminDetail {
    public String account;
    /**
     * 为了保持与数据库中表列的命名一致，暂时采取这种不规范的方式
     */
    public String register_time;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }
}
