package cn.sth.electric.vo;

import java.io.Serializable;

/**
 * ClassName:Recorder
 * Package:cn.sth.electric.vo
 * Description:
 *
 * @Date:2020/6/21 8:36
 * Author:沙天慧
 */
public class Recorder implements Serializable,Cloneable,Comparable<Recorder> {
    private Integer rnid;
    private String rname;

    public Recorder() {
    }

    public Recorder(Integer rnid, String rname) {
        this.rnid = rnid;
        this.rname = rname;
    }

    public Recorder(Recorder recorder){
        if(recorder!=null){
            this.rnid = recorder.rnid;
            this.rname = recorder.rname;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Recorder(this);
    }

    public Integer getRnid() {
        return rnid;
    }

    public void setRnid(Integer rnid) {
        this.rnid = rnid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public int compareTo(Recorder recorder) {
        return (this.rnid >= recorder.rnid?1:0);
    }
}
