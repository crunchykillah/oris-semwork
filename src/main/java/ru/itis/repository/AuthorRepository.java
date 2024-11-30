package ru.itis.repository;

import ru.itis.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    public List<Author> getAll();
    public Optional<Author> findById(Long id);
    public boolean deleteById(Long id);
    public void save(Author author);
}
