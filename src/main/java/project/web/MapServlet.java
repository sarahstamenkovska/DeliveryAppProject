package project.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import project.model.Order;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/map")
public class MapServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public MapServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }


    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Order orderPresent=(Order)session.getAttribute("order");
        if(orderPresent==null) resp.sendRedirect("/burgers");

        String  clientAddress=req.getParameter("clientAddress");
        session.setAttribute("clientAddress",clientAddress);

        String[] address=clientAddress.split(",");
        String URL="https://www.google.mk/maps/dir/Food+Hood,+MK,+11-ти+Октомври+46,+1000,+Скопје+1000/+"+address[0]+"+"+address[1]+",+Скопје+1000";


        WebContext webContext = new WebContext(req, resp, req.getServletContext());

        webContext.setVariable("url",URL);


        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("maps.html", webContext, resp.getWriter());

    }

}
