package ru.itis.service;


import ru.itis.model.Artwork;
import ru.itis.repository.ArtworkRepository;
import ru.itis.repository.ArtworkRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class ArtworkService {
    private ArtworkRepository artworkRepository;
    public ArtworkService() {
        artworkRepository = new ArtworkRepositoryImpl();
    }

    public List<Artwork> getAllArtworks() {
        return artworkRepository.getAll();
    }

    public Optional<Artwork> getArtworkById(Long id) {
        return artworkRepository.findById(id);
    }

    public boolean deleteArtworkById(Long id) {
        return artworkRepository.deleteById(id);
    }

    public void saveArtwork(Artwork artwork) {
        artworkRepository.save(artwork);
    }
    public List<Artwork> findArtworksByAuthor(Long authorId) {
        return artworkRepository.findArtworksByAuthor(authorId);
    }
    public List<Artwork> getArtworksByExhibitionId(Long exhibitionId) {
        return artworkRepository.getArtworksByExhibitionId(exhibitionId);
    }
}