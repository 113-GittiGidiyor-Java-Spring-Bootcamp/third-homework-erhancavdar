package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Instructor;
import com.example.schoolmanagement.entity.PermanentInstructor;
import com.example.schoolmanagement.entity.VisitingResearcher;

import java.util.List;

public interface InstructorService extends BaseService<Instructor> {
    public List<PermanentInstructor> getTopEarningPermanentInstructors();
    public List<VisitingResearcher> getTopEarningVisitingResearchers();
    public List<PermanentInstructor> getLowestPayedPermanentInstructors();
    public List<VisitingResearcher> getLowestPayedVisitingResearchers();


}
