package ru.itis.service;

import ru.itis.model.Author;
import ru.itis.repository.AuthorRepository;
import ru.itis.repository.AuthorRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class AuthorService {

    private AuthorRepository authorRepository;
    public AuthorService() {
        authorRepository = new AuthorRepositoryImpl();
    }

    public List<Author> getAllAuthors() {
        return authorRepository.getAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public boolean deleteAuthorById(Long id) {
        return authorRepository.deleteById(id);
    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }


}