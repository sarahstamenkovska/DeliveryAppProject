package project.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import project.model.Bread;
import project.model.Burger;
import project.model.Order;
import project.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfoServlet extends HttpServlet {
    private final OrderService orderService;
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(OrderService orderService, SpringTemplateEngine springTemplateEngine) {
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[WP-Log] doGet from ConfirmationInfoServlet");

        HttpSession session = req.getSession();

        Order orderPresent=(Order)session.getAttribute("order");
        if(orderPresent==null) resp.sendRedirect("/burgers");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("[WP-Log] doPost from ConfirmationInfoServlet");

        HttpSession session = req.getSession();
        Order orderPresent=(Order)session.getAttribute("order");
        if(orderPresent==null) resp.sendRedirect("/burgers");
        String clientAddress= (String) req.getParameter("clientAddress");
        String clientName= (String) req.getParameter("clientName");
        String clientPhone=(String) req.getParameter("clientPhone");
        Order clientOrder=(Order)req.getSession().getAttribute("order");
        Burger burgername= clientOrder.getBurger();
        Bread bread=clientOrder.getBread();

        Order newOrder = orderService.placeOrder(burgername,clientName,clientAddress,clientPhone);

        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("burgername", burgername);
       webContext.setVariable("bread_type", bread);
        webContext.setVariable("clientAddress",clientAddress);
        webContext.setVariable("clientName",clientName);
        webContext.setVariable("clientPhone",clientPhone);

        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("ConfirmationInfo.html", webContext, resp.getWriter());

    }

}
