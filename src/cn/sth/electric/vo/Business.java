package cn.sth.electric.vo;

import java.io.Serializable;

/**
 * ClassName:Business
 * Package:cn.sth.electric.vo
 * Description:
 *
 * @Date:2020/6/21 13:14
 * Author:沙天慧
 */
public class Business implements Serializable {
    private Integer bid;
    private String bname;
    private String place;
    private String corporation;
    private Integer count;
    private Integer money;
    private String phone;

    public Business() {
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
