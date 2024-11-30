package ru.itis.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ru.itis.repository.DBConnection;
import ru.itis.service.ArtworkService;
import ru.itis.service.AuthorService;
import ru.itis.service.ExhibitionService;
import ru.itis.service.VisitorService;


@WebListener
public class StartApplication implements ServletContextListener {

    private DBConnection dbConnection;

    public void contextInitialized(ServletContextEvent sce) {
        DBConnection dbConnection = DBConnection.getInstance();
        sce.getServletContext().setAttribute("ArtworkService",new ArtworkService());
        sce.getServletContext().setAttribute("AuthorService",new AuthorService());
        sce.getServletContext().setAttribute("ExhibitionService",new ExhibitionService());
        sce.getServletContext().setAttribute("VisitorService",new VisitorService());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        dbConnection.destroyConnection();
    }
}