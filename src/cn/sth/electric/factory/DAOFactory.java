package cn.sth.electric.factory;

import cn.sth.electric.dao.*;
import cn.sth.electric.dao.impl.*;

import java.sql.Connection;

/**
 * ClassName:DAOFactory
 * Package:cn.sth.electric.factory
 * Description:
 *
 * @Date:2020/6/20 22:56
 * Author:沙天慧
 */
public class DAOFactory {
    public static IUserDAO getUserDAOInstance(Connection conn){
        return new UserDAOImpl(conn);
    }
    public static IRecorderDAO getRecorderDAOInstance(Connection conn){
        return new RecorderDAOImpl(conn);
    }
    public static IBusinessDAO getBusinessDAOInstance(Connection conn){
        return new BusinessDAOImpl(conn);
    }
    public static IPriceDAO getPriceDAOInstance(Connection conn){
        return new PriceDAOImpl(conn);
    }
    public static IUseeleDAO getUseeleDAOInstance(Connection conn){
        return new UseeleDAOImpl(conn);
    }
}
