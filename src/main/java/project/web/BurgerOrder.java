package project.web;


import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import project.model.Bread;
import project.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/BurgerOrder.do")
public class BurgerOrder extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public BurgerOrder(SpringTemplateEngine springTemplateEngine)
    {
        this.springTemplateEngine=springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[WP-Log] doGet from BurgerOrder");

        HttpSession session = req.getSession();
        Order orderPresent=(Order)session.getAttribute("order");
        if(orderPresent==null) resp.sendRedirect("/burgers");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("[WP-Log] doPost from BurgerOrder");

        HttpSession session = req.getSession();

        Order orderPresent=(Order)session.getAttribute("order");
        if(orderPresent==null) resp.sendRedirect("/burgers");

        String bread_type = req.getParameter("bread_type");
        Order order= (Order) req.getSession().getAttribute("order");
        Bread bread=new Bread(bread_type);
        order.setBread(bread);
        req.getSession().setAttribute("order", order);
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("burgername", order.getBurger());
        webContext.setVariable("bread_type",bread);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("deliveryInfo.html", webContext, resp.getWriter());

    }
}
