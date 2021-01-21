package cn.sth.electric.service;

import cn.sth.electric.vo.User;

/**
 * ClassName:IUserService
 * Package:cn.sth.electric.service
 * Description:
 *
 * @Date:2020/6/20 22:54
 * Author:沙天慧
 */
public interface IUserService {
    /**
     * 实现管理员登录操作
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean login(User vo) throws Exception;
}
