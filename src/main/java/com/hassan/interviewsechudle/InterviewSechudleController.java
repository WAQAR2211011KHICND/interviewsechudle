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

    // @GetMapping("/{id}")
    // public InterviewSechudle viewSingle(@PathVariable int id){
    //     return repo.viewSingle(id);
    // }

    @PostMapping("")
    public String addinterview(@RequestBody InterviewSechudle interview){
        repo.save(interview);
        return "Interview Sechudled";
    }

    @PutMapping("")
    public String updateinterview( @RequestBody InterviewSechudle interview){
        repo.save(interview);
        return "Interview Updated "+interview.getId();
    }

    @DeleteMapping("")
    public String deleteinterview(@RequestBody InterviewSechudle interview){
        repo.delete(interview);
        return "Interview Cancalled "+interview.getId();
    }

}
