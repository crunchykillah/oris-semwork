package ru.itis.service;

import ru.itis.model.Exhibition;
import ru.itis.repository.ExhibitionRepository;
import ru.itis.repository.ExhibitionRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class ExhibitionService {
    private ExhibitionRepository exhibitionRepository;
    public ExhibitionService() {
        exhibitionRepository = new ExhibitionRepositoryImpl();
    }

    public List<Exhibition> getAllExhibitions() {
        return exhibitionRepository.getAll();
    }

    public Optional<Exhibition> getExhibitionById(Long id) {
        return exhibitionRepository.findById(id);
    }

    public boolean deleteExhibitionById(Long id) {
        return exhibitionRepository.deleteById(id);
    }

    public void saveExhibition(Exhibition exhibition) {
        exhibitionRepository.save(exhibition);
    }
    public List<Exhibition> getExhibitionsByVisitor(Long visitorId) {
        return exhibitionRepository.getExhibitionsByVisitor(visitorId);
    }
    public void saveInVisitorExhibitions(Long visitorId,Long exhibitionId) {
        exhibitionRepository.saveInVisitorExhibitions(visitorId,exhibitionId);
    }
    public boolean isVisitorRegisteredForExhibition(Long visitorId, Long exhibitionId) {
        return exhibitionRepository.isVisitorRegisteredForExhibition(visitorId,exhibitionId);
    }
}