package cn.sth.electric.dao;

import cn.sth.electric.vo.User;

/**
 * ClassName:IUserDAO
 * Package:cn.sth.electric.dao
 * Description:
 *
 * @Date:2020/6/20 22:29
 * Author:沙天慧
 */
public interface IUserDAO  extends IDAO<Integer, User>{
    /**
     * 实现登录操作
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean findLogin(User vo) throws Exception;
}
