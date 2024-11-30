package ru.itis.repository;

import ru.itis.model.Artwork;

import java.util.List;
import java.util.Optional;

public interface ArtworkRepository {
    public List<Artwork> getAll();
    public Optional<Artwork> findById(Long id);
    public boolean deleteById(Long id);
    public void save(Artwork artwork);
    public List<Artwork> findArtworksByAuthor(Long authorId);
    public List<Artwork> getArtworksByExhibitionId(Long id);

}
