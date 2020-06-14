package org.fit.kaminskii.services;

import lombok.RequiredArgsConstructor;
import org.fit.kaminskii.domain.CandidateEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.views.CandidateView;
import org.fit.kaminskii.repositories.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CandidateService {
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private Mapper4database mapper4database;

    public Page<CandidateView> showAll(int page, int size) {
//        Iterable<CandidateEntity> candidatelist = candidateRepo.findAll();
//        Page<CandidateView> candidate = new ArrayPage<>();
//        for (CandidateEntity candidateEntity : candidatelist) {
//            candidate.add(mapper4database.toCandidateView(candidateEntity));
//        }
//        return candidate;
        Page<CandidateEntity> candidatePage = candidateRepo.findAll(PageRequest.of(page, size));
        return mapper4database.toCandidatePage(candidatePage);
    }

    public void create(CandidateView candidate) {
        CandidateEntity candidateEntity = new CandidateEntity();
        mapper4database.toCandidateEntity(candidate, candidateEntity);
        candidateRepo.save(candidateEntity);
    }

    public Page<CandidateView> findCandidateByTheDepartment(String theDepartment, int page, int size) {
        Page<CandidateEntity> candidates = candidateRepo.findCandidateByTheDepartment(theDepartment, PageRequest.of(page, size));
        return mapper4database.toCandidatePage(candidates);
    }

    public Page<CandidateView> findCandidateByFaculty(String faculty, int page, int size) {
        Page<CandidateEntity> candidates = candidateRepo.findCandidateByFaculty(faculty,PageRequest.of(page, size));
        return mapper4database.toCandidatePage(candidates);
    }

    public void deleteById(String id) {
        candidateRepo.deleteById(id);
    }
}
