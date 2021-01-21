package cn.sth.electric.service.impl;

import cn.sth.electric.dbc.DataBaseConnection;
import cn.sth.electric.factory.DAOFactory;
import cn.sth.electric.service.IPriceService;
import cn.sth.electric.vo.Price;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:PriceServiceImpl
 * Package:cn.sth.electric.service.impl
 * Description:
 *
 * @Date:2020/6/21 21:49
 * Author:沙天慧
 */
public class PriceServiceImpl implements IPriceService {
    DataBaseConnection dbc=new DataBaseConnection();
    @Override
    public boolean insert(Price vo) throws Exception {
        try {
            return DAOFactory.getPriceDAOInstance(this.dbc.getConnection()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try {
            return DAOFactory.getPriceDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        return false;
    }

    @Override
    public Map<String, Object> list(int currentPage, int lineSize, String column, String keyword) throws Exception {
        try{
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("allPrice",DAOFactory.getPriceDAOInstance(this.dbc.getConnection()).findAllSplit(currentPage,lineSize,column,keyword));
            map.put("priceCount",DAOFactory.getPriceDAOInstance(this.dbc.getConnection()).getAllCount(column,keyword));
            return map;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public Price show(int pid) throws Exception {
        try {
            return DAOFactory.getPriceDAOInstance(this.dbc.getConnection()).findById(pid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dbc.close();
        }
        return null;
    }
}
