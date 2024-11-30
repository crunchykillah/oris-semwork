package ru.itis.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.model.Exhibition;
import ru.itis.service.ExhibitionService;

import java.io.IOException;
import java.util.List;

@WebServlet("/exhibitions")
public class ExhibitionsServlet extends HttpServlet {
    private ExhibitionService exhibitionService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        exhibitionService = (ExhibitionService) getServletContext().getAttribute("ExhibitionService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exhibitionId = req.getParameter("exhibitionId");
        Long visitorId = (Long) req.getSession().getAttribute("visitorid");
        List<Exhibition> exhibitionList = exhibitionService.getAllExhibitions();
        req.setAttribute("exhibitions", exhibitionList);
        if (exhibitionId != null) {
            if (exhibitionService.isVisitorRegisteredForExhibition(visitorId, Long.valueOf(exhibitionId))) {
                req.setAttribute("message", "You are already registered for this exhibition!");
                req.getRequestDispatcher("exhibitions.ftl").forward(req, resp);
                return;
            } else {
                exhibitionService.saveInVisitorExhibitions(visitorId,Long.valueOf(exhibitionId));
                req.setAttribute("message", "You have successfully registered for the exhibition!");
                req.getRequestDispatcher("exhibitions.ftl").forward(req, resp);
                return;
            }
        }
        req.getRequestDispatcher("exhibitions.ftl").forward(req, resp);
    }
}