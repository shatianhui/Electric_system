package cn.sth.electric.dao.impl;

import cn.sth.electric.dao.IRecorderDAO;
import cn.sth.electric.util.dao.AbstractDAOImpl;
import cn.sth.electric.vo.Business;
import cn.sth.electric.vo.Recorder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * ClassName:RecorderDAOImpl
 * Package:cn.sth.electric.dao.impl
 * Description:
 *
 * @Date:2020/6/21 8:49
 * Author:沙天慧
 */
public class RecorderDAOImpl extends AbstractDAOImpl implements IRecorderDAO {
    public RecorderDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Recorder vo) throws Exception {
        String sql="INSERT INTO recorder(rname) VALUES(?)";
        super.pstmt=super.conn.prepareStatement(sql);
        this.pstmt.setString(1,vo.getRname());
        return this.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Recorder vo) throws Exception {
        return false;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        return false;
    }

    @Override
    public Recorder findById(Integer id) throws Exception {
        Recorder vo=null;
        String sql="SELECT rnid,rname FROM recorder WHERE rnid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,id);
        ResultSet rs=super.pstmt.executeQuery();
        if (rs.next()){
            vo=new Recorder();
            vo.setRnid(rs.getInt(1));
            vo.setRname(rs.getString(2));
        }
        return vo;
    }


    @Override
    public List<Recorder> findAll() throws Exception {
        List<Recorder> all=new ArrayList<Recorder>();
        String sql="SELECT rnid,rname FROM recorder ";
        super.pstmt=super.conn.prepareStatement(sql);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            Recorder vo=new Recorder();
            vo.setRnid(rs.getInt(1));
            vo.setRname(rs.getString(2));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Recorder> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        return null;
    }
}
