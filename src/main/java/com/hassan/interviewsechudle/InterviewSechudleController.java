package com.hassan.interviewsechudle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("/interview")
public class InterviewSechudleController {
    
    @Autowired
    private IInterviewSechudleRepository repo;

    @GetMapping("")
    public List<InterviewSechudle> getAll(){
        return repo.findAll();
    }
    
    @GetMapping("/getByJob/{job_id}")
    public List<InterviewSechudle> getByJobId(@PathVariable int job_id){
        return repo.findByJobId(job_id);
    }

    @GetMapping("/getByCandidate/{candidate_id}")
    public List<InterviewSechudle> getByCandidateId(@PathVariable int candidate_id){
        return repo.findByCandidateId(candidate_id);
    }

    @GetMapping("/getByInterviewer/{interviewer_id}")
    public List<InterviewSechudle> getByInterviewerId(@PathVariable int interviewer_id){
        return repo.findByInterviewerId(interviewer_id);
    }

    @GetMapping("/{id}")
    public InterviewSechudle viewSingle(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping("")
    public String addinterview(@RequestBody InterviewSechudle interview){
        repo.save(interview);
        return "Interview Sechudled";
    }

    @PutMapping("")
    public String updateinterview( @RequestBody InterviewSechudle interview){
        InterviewSechudle interviewSchedule = repo.findById(interview.getId()).orElse(null);
        if(interviewSchedule != null){
            interviewSchedule.setStatus(interview.getStatus());
            if(interview.getInterviewer_feedback() != null) interviewSchedule.setInterviewer_feedback(interview.getInterviewer_feedback());
            if(interview.getCandidate_feedback() != null) interviewSchedule.setCandidate_feedback(interview.getCandidate_feedback());
            if(interview.getStatus() != 0) interviewSchedule.setStatus(interview.getStatus());
            repo.save(interviewSchedule);
        } 
        return "Interview Updated "+interview.getId();
    }

    @DeleteMapping("")
    public String deleteinterview(@RequestBody InterviewSechudle interview){
        repo.delete(interview);
        return "Interview Cancalled "+interview.getId();
    }

}
