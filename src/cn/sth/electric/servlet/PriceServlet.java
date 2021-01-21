package cn.sth.electric.servlet;

import cn.sth.electric.factory.ServiceFactory;
import cn.sth.electric.vo.Business;
import cn.sth.electric.vo.Price;

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
 * ClassName:PriceServlet
 * Package:cn.sth.electric.servlet
 * Description:
 *
 * @Date:2020/6/22 18:18
 * Author:沙天慧
 */
@WebServlet(name = "PriceServlet",urlPatterns = "/pages/PriceServlet/*")
public class PriceServlet extends HttpServlet {
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
            if (ServiceFactory.getPriceServiceInstance().delete(allIds)){
                msg="电价信息删除成功！";
            }else{
                msg="电价信息删除失败！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        url="/pages/PriceServlet"+referer.substring(referer.lastIndexOf("/"));
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
    public String insert(HttpServletRequest request,HttpServletResponse response) {
        String msg=null;
        String url=null;
        String year=request.getParameter("year");
        String month=request.getParameter("month");
        int d=Integer.parseInt(request.getParameter("day"))+1;
        String day=String.valueOf(d);
        String valley=request.getParameter("valley");
        String peak=request.getParameter("peak");
        System.out.println(year+"-"+month+"-"+day);
        Price vo=new Price();
        try {
            vo.setPubdate(new SimpleDateFormat("yyyy-MM-dd").parse(year+"-"+month+"-"+day));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        vo.setValley(Double.parseDouble(valley));
        vo.setPeak(Double.parseDouble(peak));
        try {
            if(ServiceFactory.getPriceServiceInstance().insert(vo)){
                msg="电价信息发布成功!";
            }else{
                msg="电价信息发布失败！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        url="pages/price/price_insert.jsp";
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
    public  String list(HttpServletRequest request) {
        int currentPage = 1;
        int lineSize = 5;
        String column = null;
        String keyWord = null;
        String columnData = "谷价:valley|峰价:peak";
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
            column = "valley";
        }
        if (keyWord == null) {
            keyWord = "";
        }
        try {
            Map<String, Object> map = ServiceFactory.getPriceServiceInstance().list(currentPage, lineSize, column, keyWord);
            request.setAttribute("allPrice", map.get("allPrice"));
            System.out.println(map.get("priceCount"));
            request.setAttribute("allRecorders", map.get("priceCount"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("column", column);
        request.setAttribute("keyWord", keyWord);
        request.setAttribute("columnData", columnData);
        request.setAttribute("url", "/pages/PriceServlet/list");
        return "/pages/price/price_list.jsp";
    }
}
