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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private VisitorService visitorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        visitorService = (VisitorService) getServletContext().getAttribute("VisitorService");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("regpage.ftl").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!validateUsername(username)) {
            HttpSession session = request.getSession();
            session.setAttribute("error", "This login is already in use, or you entered an empty login");
            response.sendRedirect("/online-gallery/registration");
            return;
        }

        Visitor visitor = new Visitor();
        visitor.setName(name);
        visitor.setPhoneNumber(phone);
        visitor.setEmail(email);
        visitor.setPassword(password);
        visitor.setUsername(username);

        visitorService.saveVisitor(visitor);

        HttpSession session = request.getSession();

        session.setAttribute("visitorname", visitor.getName());
        session.setAttribute("visitorid", visitor.getVisitorId());

        response.sendRedirect("/online-gallery/login");
    }

    private boolean validateUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        Optional<Visitor> existingVisitor = visitorService.findByUsername(username);
        return existingVisitor.isEmpty();
    }


}

