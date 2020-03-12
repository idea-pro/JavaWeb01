package checkcode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author 验证码的随机生成
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 200;
        int height = 100;
        /**创建验证码图片对象*/
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        /**图片美化*/
        //画笔对象
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        //填充背景色
        g.fillRect(0, 0, width, height);
        //画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);
        /**生成随机字符*/
        g.setColor(Color.black);
        String str = "123456789asdfghcvbnj";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            //保证每一个字符既不重叠也不超出边界
            g.drawString(ch+"",width/5*i,height/2);
        }
        String checkcode_session = sb.toString();
        //将验证码存入session
        request.getSession().setAttribute("checkcode_session",checkcode_session);
        /**画干扰线*/
        g.setColor(Color.green);
        for (int i = 0; i < 6; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        //将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }
}
