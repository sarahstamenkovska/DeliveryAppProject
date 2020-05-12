package project.web;


import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import project.model.Burger;
import project.service.BurgerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="burger-web-servlet", urlPatterns = "/burgers")
public class ShowBurger extends HttpServlet {
    private final BurgerService burgerService;
    private final SpringTemplateEngine springTemplateEngine;

    public ShowBurger(BurgerService burgerService, SpringTemplateEngine springTemplateEngine) {
        this.burgerService = burgerService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        List<Burger> burgers = burgerService.listBurgers();
        webContext.setVariable("burgers", burgers);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("listBurgers.html", webContext, resp.getWriter());


}
}
