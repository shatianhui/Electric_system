package cn.sth.electric.service.impl;

import cn.sth.electric.dao.IBusinessDAO;
import cn.sth.electric.dbc.DataBaseConnection;
import cn.sth.electric.factory.DAOFactory;
import cn.sth.electric.service.IBusinessService;
import cn.sth.electric.vo.Business;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:BusinessServiceImpl
 * Package:cn.sth.electric.service.impl
 * Description:
 *
 * @Date:2020/6/21 13:41
 * Author:沙天慧
 */
public class BusinessServiceImpl implements IBusinessService {
    DataBaseConnection dbc=new DataBaseConnection();
    @Override
    public boolean insert(Business vo) throws Exception {
        try {
            return DAOFactory.getBusinessDAOInstance(this.dbc.getConnection()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Business vo) throws Exception {
        try{
            return DAOFactory.getBusinessDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try {
            return DAOFactory.getBusinessDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
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
            map.put("allBusiness",DAOFactory.getBusinessDAOInstance(this.dbc.getConnection()).findAllSplit(currentPage,lineSize,column,keyword));
            map.put("businessCount",DAOFactory.getBusinessDAOInstance(this.dbc.getConnection()).getAllCount(column,keyword));
            return map;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public Business show(int bid) throws Exception {
        try {
            return DAOFactory.getBusinessDAOInstance(this.dbc.getConnection()).findById(bid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dbc.close();
        }
        return null;
    }

}
