package cn.sth.electric.service;

import cn.sth.electric.vo.Business;

import java.util.Map;
import java.util.Set;

/**
 * ClassName:IBusinessService
 * Package:cn.sth.electric.service
 * Description:
 *
 * @Date:2020/6/21 13:36
 * Author:沙天慧
 */
public interface IBusinessService {
    public boolean insert(Business vo) throws Exception;
    public boolean update(Business vo) throws Exception;
    public boolean delete(Set<Integer> ids) throws Exception;
    public Map<String,Object> list(int currentPage,int lineSize,String column,String keyword) throws Exception;
    public Business show(int bid) throws Exception;
}
