package com.url.shortener.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
public class UrlMapping {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orignalUrl;
    private String shorUrl;
    private int clickCount;
    private LocalDateTime createdDate;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "urlMapping")
    private List<ClickEvent> clickEvents;
}
