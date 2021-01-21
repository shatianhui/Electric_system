package cn.sth.electric.vo;

import java.io.Serializable;

/**
 * ClassName:User
 * Package:cn.sth.electric.vo
 * Description:
 *
 * @Date:2020/6/20 22:35
 * Author:沙天慧
 */
public class User implements Serializable {
    private Integer uno;
    private String uname;
    private String password;
    private String garde;

    public User() {
    }

    public Integer getUno() {
        return uno;
    }

    public void setUno(Integer uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGarde() {
        return garde;
    }

    public void setGarde(String garde) {
        this.garde = garde;
    }
}
