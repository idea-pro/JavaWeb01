package web;

import service.ReserveService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String kind = request.getParameter("kind");
        String name = request.getParameter("name");
        //提交到service层
        ReserveService rs = new ReserveService();
        boolean flag = rs.reserve(kind, name);
        //反馈信息
        if (flag) {
            response.sendRedirect("succeed_reserve.jsp");
        } else {
            request.setAttribute("reserve_error","预约失败！");
            request.getRequestDispatcher("/reserve.jsp").forward(request,response);
        }
    }
}
