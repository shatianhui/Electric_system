package cn.sth.electric.service.impl;

import cn.sth.electric.dbc.DataBaseConnection;
import cn.sth.electric.factory.DAOFactory;
import cn.sth.electric.service.IUseeleService;
import cn.sth.electric.service.IUserService;
import cn.sth.electric.vo.Useele;
import cn.sth.electric.vo.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:UseeleServiceImpl
 * Package:cn.sth.electric.service.impl
 * Description:
 *
 * @Date:2020/6/23 10:01
 * Author:沙天慧
 */
public class UseeleServiceImpl implements IUseeleService {
    DataBaseConnection dbc=new DataBaseConnection();

    @Override
    public boolean insert(Useele vo) throws Exception {
        try {
            return DAOFactory.getUseeleDAOInstance(this.dbc.getConnection()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try {
            return DAOFactory.getUseeleDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
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
            map.put("allUseele",DAOFactory.getUseeleDAOInstance(this.dbc.getConnection()).findAllSplit(currentPage,lineSize,column,keyword));
            map.put("useeleCount",DAOFactory.getUseeleDAOInstance(this.dbc.getConnection()).getAllCount(column,keyword));
            return map;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }


}
