package cn.sth.electric.vo;

import java.io.Serializable;

/**
 * ClassName:UseEle
 * Package:cn.sth.electric.vo
 * Description:
 *
 * @Date:2020/6/22 23:28
 * Author:沙天慧
 */
public class Useele implements Serializable {
    private Integer ueid;
    private Business business;
    private  Price price;
    private Recorder recorder;
    private String usemonth;
    private Double vcount;
    private Double pcount;

    public Useele() {
    }

    public Integer getUeid() {
        return ueid;
    }

    public void setUeid(Integer ueid) {
        this.ueid = ueid;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Recorder getRecorder() {
        return recorder;
    }

    public void setRecorder(Recorder recorder) {
        this.recorder = recorder;
    }

    public String getUsemonth() {
        return usemonth;
    }

    public void setUsemonth(String usemonth) {
        this.usemonth = usemonth;
    }

    public Double getVcount() {
        return vcount;
    }

    public void setVcount(Double vcount) {
        this.vcount = vcount;
    }

    public Double getPcount() {
        return pcount;
    }

    public void setPcount(Double pcount) {
        this.pcount = pcount;
    }
}
