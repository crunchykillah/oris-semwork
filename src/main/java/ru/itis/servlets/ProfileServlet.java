package ru.itis.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.model.Exhibition;
import ru.itis.model.Visitor;
import ru.itis.service.ExhibitionService;
import ru.itis.service.VisitorService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private VisitorService visitorService;
    private ExhibitionService exhibitionService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        visitorService = (VisitorService) getServletContext().getAttribute("VisitorService");
        exhibitionService = (ExhibitionService) getServletContext().getAttribute("ExhibitionService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long visitorId = (Long) req.getSession().getAttribute("visitorid");
        List<Exhibition> exhibitionList;

        if (visitorId != null) {
            Optional<Visitor> visitor = visitorService.getVisitorById(Long.valueOf(visitorId));
            if (visitor.isPresent()) {
                exhibitionList = exhibitionService.getExhibitionsByVisitor(Long.valueOf(visitorId));
                req.setAttribute("exhibitions", exhibitionList);
                req.setAttribute("user", visitor.get());
                req.getRequestDispatcher("profile.ftl").forward(req, resp);
            }
        }
    }

}
