package com.hassan.interviewsechudle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/interview")//http://localhost:8080/interview
public class InterviewSechudleController {
    
    @Autowired
    IInterviewSechudle repo;

    @GetMapping("")
    public List<InterviewSechudle> getAll(){
        return repo.findAll();
    } 

    // public InterviewSechudleController(){
    //     repo = new InterviewSechudleRepository();
    // }

    // @GetMapping("")
    // public Collection<InterviewSechudle> viewAll(){
    //     return repo.viewAll();
    // }

    // @GetMapping("{id}")
    // public InterviewSechudle viewSingle(@PathVariable int id){
    //     return repo.viewSingle(id);
    // }

    @PostMapping("")
    public String addinterview(@RequestBody InterviewSechudle interview){
        repo.save(interview);
        return "Interview Sechudled "+interview.getId();
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
