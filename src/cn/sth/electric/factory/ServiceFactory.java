package cn.sth.electric.factory;

import cn.sth.electric.dao.IRecorderDAO;
import cn.sth.electric.dao.impl.RecorderDAOImpl;
import cn.sth.electric.service.*;
import cn.sth.electric.service.impl.*;

/**
 * ClassName:ServiceFactory
 * Package:cn.sth.electric.factory
 * Description:
 *
 * @Date:2020/6/20 23:04
 * Author:沙天慧
 */
public class ServiceFactory {
    public static IUserService getUserServiceInstance(){
        return new UserServiceImpl();
    }
    public static IRecorderService getRecorderServiceInstance(){
        return new RecorderServiceImpl();
    }
    public static IBusinessService getBusinessServiceInstance(){
        return new BusinessServiceImpl();
    }
    public static IPriceService getPriceServiceInstance(){
        return new PriceServiceImpl();
    }
    public static IUseeleService getUseeleServiceInstance(){
        return new UseeleServiceImpl();
    }
}
