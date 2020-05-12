package project.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import project.model.Burger;
import project.model.Order;
import project.service.BurgerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "burger-servlet", urlPatterns = "/selectBurger.do")

public class SelectBurger extends HttpServlet {

    private BurgerService burgerService;
    private SpringTemplateEngine springTemplateEngine;

    public SelectBurger(BurgerService burgerService, SpringTemplateEngine springTemplateEngine) {
        this.burgerService = burgerService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("[WP-Log] doPost from SelectBurger");
        HttpSession session = req.getSession();
        String burgername = req.getParameter("burger");
        if(burgername==null) resp.sendRedirect("/burgers");



        Order order =new Order();
        Burger burger=burgerService.getByName(burgername);
        order.setBurger(burger);
        session.setAttribute("order",order);
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("burgername", burgername);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("selectBread.html", webContext, resp.getWriter());
    }
}
