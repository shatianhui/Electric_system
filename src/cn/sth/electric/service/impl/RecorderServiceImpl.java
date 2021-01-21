package cn.sth.electric.service.impl;

import cn.sth.electric.dao.IRecorderDAO;
import cn.sth.electric.dbc.DataBaseConnection;
import cn.sth.electric.factory.DAOFactory;
import cn.sth.electric.service.IRecorderService;
import cn.sth.electric.vo.Recorder;

import java.util.List;
import java.util.Set;

/**
 * ClassName:RecorderServiceImpl
 * Package:cn.sth.electric.service.impl
 * Description:
 *
 * @Date:2020/6/21 9:06
 * Author:沙天慧
 */
public class RecorderServiceImpl implements IRecorderService {
    DataBaseConnection dbc=new DataBaseConnection();

    @Override
    public boolean insert(Recorder vo) throws Exception {
        try{
            return DAOFactory.getRecorderDAOInstance(this.dbc.getConnection()).doCreate(vo);
        }catch (Exception e){
            throw  e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Recorder> list() throws Exception {
        try{
            return DAOFactory.getRecorderDAOInstance(this.dbc.getConnection()).findAll();
        }catch (Exception e){
            throw  e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public Recorder show(int rnid) throws Exception {
        try {
            return DAOFactory.getRecorderDAOInstance(this.dbc.getConnection()).findById(rnid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dbc.close();
        }
        return null;
    }
}
