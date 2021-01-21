package cn.sth.electric.service;

import cn.sth.electric.vo.Price;
import cn.sth.electric.vo.Useele;

import java.util.Map;
import java.util.Set;

/**
 * ClassName:IUseeleService
 * Package:cn.sth.electric.service
 * Description:
 *
 * @Date:2020/6/23 10:00
 * Author:沙天慧
 */
public interface IUseeleService {
    public boolean insert(Useele vo) throws Exception;
    public boolean delete(Set<Integer> ids) throws Exception;
    public Map<String,Object> list(int currentPage, int lineSize, String column, String keyword) throws Exception;
}
