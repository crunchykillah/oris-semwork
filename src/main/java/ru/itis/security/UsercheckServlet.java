package ru.itis.security;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.model.Visitor;
import ru.itis.service.VisitorService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {

    private VisitorService visitorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        visitorService = (VisitorService) getServletContext().getAttribute("VisitorService");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Optional<Visitor> visitorOptional = visitorService.findByUsername(username);
        if (visitorOptional.isPresent()) {
            if ( visitorOptional.get().getPassword().equals(password)) {

                HttpSession session = request.getSession();

                session.setAttribute("visitorname", visitorOptional.get().getName());
                session.setAttribute("visitorid", visitorOptional.get().getVisitorId());

                response.sendRedirect("/online-gallery/gallery");

            } else {
                request.setAttribute("message", "Incorrect password or login");
                request.getRequestDispatcher("login.ftl").forward(request, response);
            }
        }
    }

}
