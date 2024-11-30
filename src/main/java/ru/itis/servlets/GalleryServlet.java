package ru.itis.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.model.Artwork;
import ru.itis.model.Author;
import ru.itis.service.ArtworkService;
import ru.itis.service.AuthorService;

import java.io.IOException;
import java.util.List;

@WebServlet("/gallery")
public class GalleryServlet extends HttpServlet {
    private AuthorService authorService;
    private ArtworkService artworkService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        authorService = (AuthorService) getServletContext().getAttribute("AuthorService");
        artworkService = (ArtworkService) getServletContext().getAttribute("ArtworkService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authors = authorService.getAllAuthors();
        List<Artwork> artworks;
        String selectedAuthor = req.getParameter("author");
        if (selectedAuthor == null || selectedAuthor.isEmpty()) {
            artworks = artworkService.getAllArtworks();
        } else {
            Long selectedAuthorId = Long.valueOf(selectedAuthor);
            artworks = artworkService.findArtworksByAuthor(selectedAuthorId);
        }

        req.setAttribute("authors", authors);
        req.setAttribute("artworks", artworks);

        req.getRequestDispatcher("gallery.ftl").forward(req, resp);
    }
}
