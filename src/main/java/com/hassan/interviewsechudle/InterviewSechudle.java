package com.hassan.interviewsechudle;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="interviews")
@Getter

public class InterviewSechudle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private int jobId;
    @Setter
    private String jobTitle;
    @Setter
    private int interviewerId;
    @Setter
    private String interviewer_name;
    @Setter
    private String candidate_name;
    @Setter
    private int candidateId;
    @Setter
    @Column(columnDefinition = "date")
    private Date interview_date;
    @Setter
    private String interview_time;
    @Setter
    private int status;
    @Setter
    private String interviewer_feedback;
    @Setter
    private String candidate_feedback;

}

