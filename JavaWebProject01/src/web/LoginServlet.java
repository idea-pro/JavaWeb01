package web;

import domain.User;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 24208
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**设置字符编码*/
        request.setCharacterEncoding("utf-8");
        /**获取参数*/
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        /**获取生成的验证码*/
        HttpSession session = request.getSession();
        String checkcode_session = (String) session.getAttribute("checkcode_session");
        /**删除session中存储的验证码*/
        session.removeAttribute("checkcode_session");
        /**判断验证码生成是否正确*/
        if (checkcode_session != null && checkcode_session.equalsIgnoreCase(checkcode)) {
            //调用service层的方法
            LoginService loginService = new LoginService();
            User user = loginService.login(username,password);
            boolean flag = true;
            if(user == null) {
                flag = false;
            }
            //判断是否成功登录
            if(flag) {
                //将username存入session中显示用户名
                request.getSession().setAttribute("username",username);
                response.sendRedirect("success.jsp");
            }
            else {
                request.setAttribute("login_error","用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        } else {
            request.setAttribute("checkcode_error","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
