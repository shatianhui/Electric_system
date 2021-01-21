package cn.sth.electric.dao.impl;

import cn.sth.electric.dao.IBusinessDAO;
import cn.sth.electric.dao.IDAO;
import cn.sth.electric.dao.IPriceDAO;
import cn.sth.electric.util.dao.AbstractDAOImpl;
import cn.sth.electric.vo.Business;
import cn.sth.electric.vo.Price;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * ClassName:PriceDAOImpl
 * Package:cn.sth.electric.dao.impl
 * Description:
 *
 * @Date:2020/6/21 21:37
 * Author:沙天慧
 */
public class PriceDAOImpl extends AbstractDAOImpl implements IPriceDAO {
    public PriceDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Price vo) throws Exception {
        String sql="INSERT INTO price(pubdate,valley,peak) VALUES(?,?,?)";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setTimestamp(1,new java.sql.Timestamp(vo.getPubdate().getTime()));
        super.pstmt.setDouble(2,vo.getValley());
        super.pstmt.setDouble(3,vo.getPeak());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Price vo) throws Exception {
        return false;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        return super.removeHandle("price","pid",ids);
    }

    @Override
    public Price findById(Integer id) throws Exception {
        Price vo=null;
        String sql="SELECT pid,pubdate,valley,peak FROM price WHERE pid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,id);
        ResultSet rs=super.pstmt.executeQuery();
        if (rs.next()){
            vo=new Price();
            vo.setPid(rs.getInt(1));
            vo.setPubdate(rs.getDate(2));
            vo.setValley(rs.getDouble(3));
            vo.setPeak(rs.getDouble(4));
        }
        return vo;
    }

    @Override
    public List<Price> findAll() throws Exception {
        return null;
    }

    @Override
    public List<Price> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        List<Price> all=new ArrayList<Price>();
        String sql="SELECT pid,pubdate,valley,peak FROM price WHERE "+
                column+" LIKE ? LIMIT ?,?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        super.pstmt.setInt(2,(currentPage-1)*lineSize);
        super.pstmt.setInt(3,lineSize);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            Price vo=new Price();
            vo.setPid(rs.getInt(1));
            vo.setPubdate(rs.getDate(2));
            vo.setValley(rs.getDouble(3));
            vo.setPeak(rs.getDouble(4));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        String sql="SELECT COUNT(*) FROM price WHERE "+column+" LIKE ? ";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
}
