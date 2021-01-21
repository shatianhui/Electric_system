package cn.sth.electric.dao.impl;

import cn.sth.electric.dao.IUserDAO;
import cn.sth.electric.util.dao.AbstractDAOImpl;
import cn.sth.electric.vo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName:UserDAOImpl
 * Package:cn.sth.electric.dao.impl
 * Description:
 *
 * @Date:2020/6/20 22:33
 * Author:沙天慧
 */
public class UserDAOImpl extends AbstractDAOImpl implements IUserDAO {
    public UserDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(User vo) throws Exception {
        return false;
    }

    @Override
    public boolean doUpdate(User vo) throws Exception {
        return false;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        return false;
    }

    @Override
    public User findById(Integer id) throws Exception {
        return null;
    }


    @Override
    public List<User> findAll() throws Exception {
        return null;
    }

    @Override
    public List<User> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public boolean findLogin(User vo) throws Exception {
        boolean flag=false;
        String sql="SELECT uno FROM user WHERE uname=? and password=? and grade=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getUname());
        super.pstmt.setString(2,vo.getPassword());
        super.pstmt.setString(3,vo.getGarde());
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            flag=true;
        }
        return flag;
    }
}
