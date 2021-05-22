package com.example.demo.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @SequenceGenerator(name = "tasks_seq", sequenceName =
            "tasks_sequence", allocationSize = 1)
    @GeneratedValue(generator = "tasks_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "question", length = 40)
    private String ques;
    @Column(name = "ans", length = 20)
    private String ans;
    @Column(name = "type", length = 15)
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

