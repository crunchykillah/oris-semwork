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
import java.util.Optional;

@WebServlet("/author")
public class AuthorServlet extends HttpServlet {
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
        List<Artwork> artworks = null;
        Optional<Author> optionalAuthor = null;
        String authorId = req.getParameter("id");

        if (authorId != null && !authorId.isEmpty()) {
            artworks = artworkService.findArtworksByAuthor(Long.valueOf(authorId));
            optionalAuthor = authorService.getAuthorById(Long.valueOf(authorId));
        }

        if (optionalAuthor.isPresent() && artworks != null) {
            req.setAttribute("author",optionalAuthor.get() );
            req.setAttribute("artworks", artworks);
        }
        req.getRequestDispatcher("author.ftl").forward(req, resp);
    }
}