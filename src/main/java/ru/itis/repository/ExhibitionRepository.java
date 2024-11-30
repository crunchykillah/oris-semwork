package ru.itis.repository;

import ru.itis.model.Exhibition;

import java.util.List;
import java.util.Optional;

public interface ExhibitionRepository {
    public List<Exhibition> getAll();
    public Optional<Exhibition> findById(Long id);
    public boolean deleteById(Long id);
    public void save(Exhibition exhibition);
    public List<Exhibition> getExhibitionsByVisitor(Long id);
    public void saveInVisitorExhibitions(Long visitorId,Long exhibitionId);
    public boolean isVisitorRegisteredForExhibition(Long visitorId, Long exhibitionId);
}
