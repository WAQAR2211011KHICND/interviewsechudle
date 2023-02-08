package com.hassan.interviewsechudle;

// import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="interview_list")
@Getter

public class InterviewSechudle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private int job_id;
    @Setter
    private int candidate_id;
    @Setter
    private String interview_date;
    @Setter
    private String interview_time;

    // public InterviewSechudle(){

    // }
    
    // public InterviewSechudle(int id, int job_id, int candidate_id, String interview_date,String interview_time){
    //     this.id = id;
    //     this.job_id = job_id;
    //     this.candidate_id = candidate_id;
    //     this.interview_date = interview_date;
    //     this.interview_time = interview_time;
    // }


    

}

