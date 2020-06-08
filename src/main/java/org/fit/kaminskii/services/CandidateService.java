package org.fit.kaminskii.services;

import org.fit.kaminskii.domain.CandidateEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.views.CandidateView;
import org.fit.kaminskii.repositories.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CandidateService {
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private Mapper4database mapper4database;

    public List<CandidateView> showAll() {
        Iterable<CandidateEntity> candidatelist = candidateRepo.findAll();
        List<CandidateView> candidate = new ArrayList<>();
        for (CandidateEntity candidateEntity : candidatelist) {
            candidate.add(mapper4database.toCandidateView(candidateEntity));
        }
        return candidate;
    }

    public void create(CandidateView candidate) {
        CandidateEntity candidateEntity = new CandidateEntity();
        mapper4database.toCandidateEntity(candidate, candidateEntity);
        candidateRepo.save(candidateEntity);
    }

    public List<CandidateView> findCandidateByTheDepartment(String department) {
        List<CandidateEntity> candidates = candidateRepo.findCandidateByTheDepartment(department);
        return mapper4database.toCandidateListView(candidates);
    }

    public List<CandidateView> findCandidateByFaculty(String faculty) {
        List<CandidateEntity> candidates = candidateRepo.findCandidateByFaculty(faculty);
        return mapper4database.toCandidateListView(candidates);
    }

    public void deleteById(String id) {
        candidateRepo.deleteById(id);
    }
}
