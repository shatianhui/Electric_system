package cn.sth.electric.dao.impl;

import cn.sth.electric.dao.IBusinessDAO;
import cn.sth.electric.util.dao.AbstractDAOImpl;
import cn.sth.electric.vo.Business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * ClassName:BusinessDAOImpl
 * Package:cn.sth.electric.dao.impl
 * Description:
 *
 * @Date:2020/6/21 13:18
 * Author:沙天慧
 */
public class BusinessDAOImpl extends AbstractDAOImpl implements IBusinessDAO {
    public BusinessDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Business vo) throws Exception {
        String sql="INSERT INTO business(bname,place,corporation,count,money,phone) VALUES(?,?,?,?,?,?)";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getBname());
        super.pstmt.setString(2,vo.getPlace());
        super.pstmt.setString(3,vo.getCorporation());
        super.pstmt.setInt(4,vo.getCount());
        super.pstmt.setInt(5,vo.getMoney());
        super.pstmt.setString(6,vo.getPhone());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Business vo) throws Exception {
        String sql="UPDATE business SET bname=?,place=?,corporation=?,count=?,money=?,phone=? WHERE bid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getBname());
        super.pstmt.setString(2,vo.getPlace());
        super.pstmt.setString(3,vo.getCorporation());
        super.pstmt.setInt(4,vo.getCount());
        super.pstmt.setInt(5,vo.getMoney());
        super.pstmt.setString(6,vo.getPhone());
        super.pstmt.setInt(7,vo.getBid());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        return super.removeHandle("business","bid",ids);
    }

    @Override
    public Business findById(Integer id) throws Exception {
        Business vo=null;
        String sql="SELECT bid,bname,place,corporation,count,money,phone FROM business WHERE bid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,id);
        ResultSet rs=super.pstmt.executeQuery();
        if (rs.next()){
            vo=new Business();
           vo.setBid(rs.getInt(1));
           vo.setBname(rs.getString(2));
           vo.setPlace(rs.getString(3));
           vo.setCorporation(rs.getString(4));
           vo.setCount(rs.getInt(5));
           vo.setMoney(rs.getInt(6));
           vo.setPhone(rs.getString(7));
        }
        return vo;
    }


    @Override
    public List<Business> findAll() throws Exception {
        return null;
    }

    @Override
    public List<Business> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        List<Business> all=new ArrayList<Business>();
        String sql="SELECT bid,bname,place,corporation,count,money,phone FROM business WHERE "+
                column+" LIKE ? LIMIT ?,?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        super.pstmt.setInt(2,(currentPage-1)*lineSize);
        super.pstmt.setInt(3,lineSize);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            Business vo=new Business();
            vo.setBid(rs.getInt(1));
            vo.setBname(rs.getString(2));
            vo.setPlace(rs.getString(3));
            vo.setCorporation(rs.getString(4));
            vo.setCount(rs.getInt(5));
            vo.setMoney(rs.getInt(6));
            vo.setPhone(rs.getString(7));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        String sql="SELECT COUNT(*) FROM business WHERE "+column+" LIKE ? ";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
}
