package cn.sth.electric.service;

import cn.sth.electric.vo.Business;
import cn.sth.electric.vo.Price;

import java.util.Map;
import java.util.Set;

/**
 * ClassName:IPriceService
 * Package:cn.sth.electric.service
 * Description:
 *
 * @Date:2020/6/21 21:48
 * Author:沙天慧
 */
public interface IPriceService {
    public boolean insert(Price vo) throws Exception;
    public boolean delete(Set<Integer> ids) throws Exception;
    public Map<String,Object> list(int currentPage, int lineSize, String column, String keyword) throws Exception;
    public Price show(int pid) throws Exception;
}
