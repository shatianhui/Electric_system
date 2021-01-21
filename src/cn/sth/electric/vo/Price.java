package cn.sth.electric.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:Price
 * Package:cn.sth.electric.vo
 * Description:
 *
 * @Date:2020/6/21 21:30
 * Author:沙天慧
 */
public class Price  implements Serializable {
    private Integer pid;
    private Date pubdate;
    private  Double valley;
    private  Double peak;

    public Price() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Double getValley() {
        return valley;
    }

    public void setValley(Double valley) {
        this.valley = valley;
    }

    public Double getPeak() {
        return peak;
    }

    public void setPeak(Double peak) {
        this.peak = peak;
    }
}
