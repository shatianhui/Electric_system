package cn.sth.electric.service;

import cn.sth.electric.vo.Price;
import cn.sth.electric.vo.Recorder;

import java.util.List;

/**
 * ClassName:IRecorderService
 * Package:cn.sth.electric.service
 * Description:
 *
 * @Date:2020/6/21 9:02
 * Author:沙天慧
 */
public interface IRecorderService {
    public boolean insert(Recorder vo) throws Exception;
    public List<Recorder> list() throws Exception;
    public Recorder show(int rnid) throws Exception;
}
