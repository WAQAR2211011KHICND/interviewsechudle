package com.hassan.interviewsechudle;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface IInterviewSechudleRepository extends JpaRepository<InterviewSechudle,Long >{
    public List<InterviewSechudle> findByJobId(int job_id);
    public List<InterviewSechudle> findByCandidateId(int candidate_id);
}
