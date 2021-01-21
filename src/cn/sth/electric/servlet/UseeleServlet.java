package cn.sth.electric.servlet;

import cn.sth.electric.factory.ServiceFactory;
import cn.sth.electric.vo.Business;
import cn.sth.electric.vo.Price;
import cn.sth.electric.vo.Recorder;
import cn.sth.electric.vo.Useele;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:UseeleServlet
 * Package:cn.sth.electric.servlet
 * Description:
 *
 * @Date:2020/6/23 10:06
 * Author:沙天慧
 */
@WebServlet(name = "UseeleServlet",urlPatterns = "/pages/UseeleServlet/*")
public class UseeleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="/pages/errors.jsp";
        String status=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        System.out.println(status);
        if(status!=null){
            if("insert".equals(status)){
                path=this.insert(request,response);
            }else if("list".equals(status)){
                path=this.list(request);
            }else if("delete".equals(status)){
                path=this.delete(request);
            }else if("show".equals(status)){
                path=this.show(request);
            }
        }
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    public String insert(HttpServletRequest request,HttpServletResponse response) {
        String msg=null;
        String url=null;
        String bid=request.getParameter("bid");
        String pid=request.getParameter("pid");
        String rnid=request.getParameter("rnid");
        String year=request.getParameter("year");
        String month=request.getParameter("month");
        String usemonth=year+"年"+month+"月";
        String vcount=request.getParameter("vcount");
        String pcount=request.getParameter("pcount");
        Useele vo=new Useele();
        Business business=new Business();
        business.setBid(Integer.parseInt(bid));
        vo.setBusiness(business);
        Price price=new Price();
        price.setPid(Integer.parseInt(pid));
        vo.setPrice(price);
        Recorder recorder=new Recorder();
        recorder.setRnid(Integer.parseInt(rnid));
        vo.setRecorder(recorder);
        vo.setUsemonth(usemonth);
        vo.setVcount(Double.parseDouble(vcount));
        vo.setPcount(Double.parseDouble(pcount));
        try {
            if(ServiceFactory.getUseeleServiceInstance().insert(vo)){
                msg="企业用电信息发布成功!";
            }else{
                msg="企业用电信息发布失败！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        url="pages/useele/useele_insert.jsp";
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
    public String delete(HttpServletRequest request){
        String referer=request.getHeader("referer");//取得之前的路径
        String msg=null;
        String url=null;
        String ids=request.getParameter("ids");
        System.out.println(ids);
        Set<Integer> allIds=new HashSet<Integer>();
        String result[]=ids.split("\\|");
        for(int i=0;i<result.length;i++){
            allIds.add(Integer.parseInt(result[i]));
        }
        try {
            if (ServiceFactory.getUseeleServiceInstance().delete(allIds)){
                msg="企业用电信息删除成功！";
            }else{
                msg="企业用电信息删除失败！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        url="/pages/UseeleServlet"+referer.substring(referer.lastIndexOf("/"));
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
    public  String list(HttpServletRequest request) {
        int currentPage = 1;
        int lineSize = 5;
        String column = null;
        String keyWord = null;
        String columnData = "企业编号:bid|电价编号:pid|抄表人编号:rnid";
        try {
            currentPage = Integer.parseInt(request.getParameter("cp"));
        } catch (Exception e) {
        }
        try {
            lineSize = Integer.parseInt(request.getParameter("ls"));
        } catch (Exception e) {
        }
        column = request.getParameter("col");
        keyWord = request.getParameter("kw");
        if (column == null) {
            column = "bid";
        }
        if (keyWord == null) {
            keyWord = "";
        }
        try {
            Map<String, Object> map = ServiceFactory.getUseeleServiceInstance().list(currentPage, lineSize, column, keyWord);
            request.setAttribute("allUseele", map.get("allUseele"));
            System.out.println(map.get("useeleCount"));
            request.setAttribute("allRecorders", map.get("useeleCount"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("column", column);
        request.setAttribute("keyWord", keyWord);
        request.setAttribute("columnData", columnData);
        request.setAttribute("url", "/pages/UseeleServlet/list");
        return "/pages/useele/useele_list.jsp";
    }
    public String show(HttpServletRequest request){
        int bid=Integer.parseInt(request.getParameter("bid"));
        int pid=Integer.parseInt(request.getParameter("pid"));
        int rnid=Integer.parseInt(request.getParameter("rnid"));
        try {
            request.setAttribute("business",ServiceFactory.getBusinessServiceInstance().show(bid));
            request.setAttribute("price",ServiceFactory.getPriceServiceInstance().show(pid));
            request.setAttribute("recorder",ServiceFactory.getRecorderServiceInstance().show(rnid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/useele/useele_show.jsp";
    }
}
