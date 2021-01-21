package cn.sth.electric.servlet;

import cn.sth.electric.factory.ServiceFactory;
import cn.sth.electric.vo.Recorder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:RecorderServlet
 * Package:cn.sth.electric.servlet
 * Description:
 *
 * @Date:2020/6/21 9:11
 * Author:沙天慧
 */
@WebServlet(name = "RecorderServlet",urlPatterns = "/pages/RecorderServlet/*")
public class RecorderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="/pages/errors.jsp";
        String status=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        System.out.println(status);
        if(status!=null){
            if("insert".equals(status)){
                path = this.insert(request) ;
            } else if ("list".equals(status)) {
                path=this.list(request);
            }
        }
        request.getRequestDispatcher(path).forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    public String insert(HttpServletRequest request){
        String msg=null;
        String url=null;
        String rname=request.getParameter("rname");
            try{
                Recorder vo=new Recorder();
                vo.setRname(rname);
                if(ServiceFactory.getRecorderServiceInstance().insert(vo)){
                    msg="抄表人信息增加成功！";
                }else {
                    msg="抄表人信息增加失败！";
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        url="/pages/recorder/recorders_insert.jsp";
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
    public String list(HttpServletRequest request){
        try {
            System.out.println(ServiceFactory.getRecorderServiceInstance().list());
            request.setAttribute("allRecorders",ServiceFactory.getRecorderServiceInstance().list());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/recorder/recorders_list.jsp";
    }
}
