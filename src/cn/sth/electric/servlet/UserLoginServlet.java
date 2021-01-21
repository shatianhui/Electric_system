package cn.sth.electric.servlet;

import cn.sth.electric.factory.ServiceFactory;
import cn.sth.electric.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:UserLoginServlet
 * Package:cn.sth.electric.servlet
 * Description:
 *
 * @Date:2020/6/20 23:08
 * Author:沙天慧
 */
@WebServlet(name = "UserLoginServlet",urlPatterns = "/pages/UserLoginServlet/*")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="/pages/errors.jsp";
        String status=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        System.out.println(status);
        if(status!=null){
            if("login".equals(status)){
                path = this.login(request) ;
            }else if ("logout".equals(status)){
                path = this.logout(request,response) ;
            }
        }
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    public  String login(HttpServletRequest request){
        String msg=null;
        String url=null;
        String uname=request.getParameter("uname");
        String password=request.getParameter("password");
        String grade=request.getParameter("grade");
        System.out.println(uname+password+grade);
        User vo=new User();
        vo.setUname(uname);
        vo.setPassword(password);
        vo.setGarde(grade);
        try {
            System.out.println(ServiceFactory.getUserServiceInstance().login(vo));
            if (ServiceFactory.getUserServiceInstance().login(vo)) {
                request.getSession().setAttribute("uname", vo.getUname());
                msg = "登录成功，欢迎光临！";
                url = "/pages/index.jsp";
            } else {
                msg = "管理员登录失败，错误的用户名或密码！";
                url = "/pages/login.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
    public String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        request.setAttribute("msg","注销成功！");
        request.setAttribute("url","/pages/login.jsp");
        return "/pages/forward.jsp";
    }
}
