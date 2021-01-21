package cn.sth.electric.dao.impl;

import cn.sth.electric.dao.IUseeleDAO;
import cn.sth.electric.util.dao.AbstractDAOImpl;
import cn.sth.electric.vo.Business;
import cn.sth.electric.vo.Price;
import cn.sth.electric.vo.Recorder;
import cn.sth.electric.vo.Useele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * ClassName:UseEleDAOImpl
 * Package:cn.sth.electric.dao.impl
 * Description:
 *
 * @Date:2020/6/22 23:33
 * Author:沙天慧
 */
public class UseeleDAOImpl extends AbstractDAOImpl implements IUseeleDAO {
    public UseeleDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Useele vo) throws Exception {
        String sql="INSERT INTO useele(bid,pid,rnid,usemonth,vcount,pcount) VALUES(?,?,?,?,?,?)";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getBusiness().getBid());
        super.pstmt.setInt(2,vo.getPrice().getPid());
        super.pstmt.setInt(3,vo.getRecorder().getRnid());
        super.pstmt.setString(4,vo.getUsemonth());
        super.pstmt.setDouble(5,vo.getVcount());
        super.pstmt.setDouble(6,vo.getPcount());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Useele vo) throws Exception {
        return false;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        return super.removeHandle("useele","ueid",ids);
    }

    @Override
    public Useele findById(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Useele> findAll() throws Exception {
        return null;
    }

    @Override
    public List<Useele> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        List<Useele> all=new ArrayList<Useele>();
        String sql="SELECT ueid,bid,pid,rnid,usemonth,vcount,pcount FROM useele WHERE "+
                column+" LIKE ? LIMIT ?,?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        super.pstmt.setInt(2,(currentPage-1)*lineSize);
        super.pstmt.setInt(3,lineSize);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            Useele vo=new Useele();
            vo.setUeid(rs.getInt(1));
            Business business=new Business();
            business.setBid(rs.getInt(2));
            vo.setBusiness(business);
            Price price=new Price();
            price.setPid(rs.getInt(3));
            vo.setPrice(price);
            Recorder recorder=new Recorder();
            recorder.setRnid(rs.getInt(4));
            vo.setRecorder(recorder);
            vo.setUsemonth(rs.getString(5));
            vo.setVcount(rs.getDouble(6));
            vo.setPcount(rs.getDouble(7));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        String sql="SELECT COUNT(*) FROM useele WHERE "+column+" LIKE ? ";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
}
