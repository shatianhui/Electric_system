package cn.sth.electric.servlet;

import cn.sth.electric.factory.ServiceFactory;
import cn.sth.electric.vo.Business;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * ClassName:BusinessServlet
 * Package:cn.sth.electric.servlet
 * Description:
 *
 * @Date:2020/6/21 15:29
 * Author:沙天慧
 */
@WebServlet(name = "BusinessServlet",urlPatterns = "/pages/BusinessServlet/*")
public class BusinessServlet  extends HttpServlet {
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
            }else if("update".equals(status)){
                path=this.update(request,response);
            }else if("delete".equals(status)){
                path=this.delete(request);
            }
        }
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
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
                if (ServiceFactory.getBusinessServiceInstance().delete(allIds)){
                    msg="企业信息删除成功！";
                }else{
                    msg="企业信息删除失败！";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        url="/pages/BusinessServlet"+referer.substring(referer.lastIndexOf("/"));
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
    public String insert(HttpServletRequest request,HttpServletResponse response){
        String msg=null;
        String url=null;
        String bname=request.getParameter("bname");
        String place=request.getParameter("place");
        String corporation=request.getParameter("corporation");
        String count=request.getParameter("count");
        String money=request.getParameter("money");
        String phone=request.getParameter("phone");
        Business vo=new Business();
        vo.setBname(bname);
        vo.setPlace(place);
        vo.setCorporation(corporation);
        vo.setCount(Integer.parseInt(count));
        vo.setMoney(Integer.parseInt(money));
        vo.setPhone(phone);
            try {
                if(ServiceFactory.getBusinessServiceInstance().insert(vo)){
                    msg="企业信息发布成功!";
                }else{
                    msg="企业信息发布失败！";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        url="pages/business/business_insert.jsp";
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
    public  String list(HttpServletRequest request) {
        int currentPage = 1;
        int lineSize = 5;
        String column = null;
        String keyWord = null;
        String columnData = "企业名称:bname|地址:place";//
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
            column = "bname";
        }
        if (keyWord == null) {
            keyWord = "";
        }
        try {
            Map<String, Object> map = ServiceFactory.getBusinessServiceInstance().list(currentPage, lineSize, column, keyWord);
            System.out.println(map.get("allBusiness"));
            request.setAttribute("allBusiness", map.get("allBusiness"));
            request.setAttribute("allRecorders", map.get("businessCount"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("column", column);
        request.setAttribute("keyWord", keyWord);
        request.setAttribute("columnData", columnData);
        request.setAttribute("url", "/pages/BusinessServlet/list");
        return "/pages/business/business_list.jsp";
    }
    public String update(HttpServletRequest request,HttpServletResponse response){
        String msg=null;
        String url=null;
        String bid=request.getParameter("bid");
        String bname=request.getParameter("bname");
        String place=request.getParameter("place");
        String corporation=request.getParameter("corporation");
        String count=request.getParameter("count");
        String money=request.getParameter("money");
        String phone=request.getParameter("phone");
        Business vo=new Business();
        vo.setBid(Integer.parseInt(bid));
        vo.setBname(bname);
        vo.setPlace(place);
        vo.setCorporation(corporation);
        vo.setCount(Integer.parseInt(count));
        vo.setMoney(Integer.parseInt(money));
        vo.setPhone(phone);
            try {
                if(ServiceFactory.getBusinessServiceInstance().update(vo)){
                    msg="企业信息修改成功!";
                }else{
                    msg="企业信息修改失败！";
                }
                url="/pages/BusinessServlet/list";
            } catch (Exception e) {
                e.printStackTrace();
            }
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
}
