package cn.sth.electric.service.impl;

import cn.sth.electric.dbc.DataBaseConnection;
import cn.sth.electric.factory.DAOFactory;
import cn.sth.electric.service.IUserService;
import cn.sth.electric.vo.User;

/**
 * ClassName:UserServiceImpl
 * Package:cn.sth.electric.service.impl
 * Description:
 *
 * @Date:2020/6/20 22:59
 * Author:沙天慧
 */
public class UserServiceImpl implements IUserService {
    DataBaseConnection dbc=new DataBaseConnection();
    @Override
    public boolean login(User vo) throws Exception {
        try{
            return DAOFactory.getUserDAOInstance(this.dbc.getConnection()).findLogin(vo);
        }catch (Exception e){
            throw  e;
        }finally {
            this.dbc.close();
        }
    }
}
