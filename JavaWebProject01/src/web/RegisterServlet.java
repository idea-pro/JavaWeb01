package web;

import service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 实现注册功能
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收界面参数
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //将参数传入service层
        RegisterService registerService = new RegisterService();
        boolean flag = registerService.registerUser(username, password);

        //反馈注册信息到页面
        if (flag) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("register_error", "该用户已存在，注册失败！");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
