package com.example.demo;import jakarta.persistence.Entity;import jakarta.persistence.GeneratedValue;import jakarta.persistence.GenerationType;import jakarta.persistence.Id;import lombok.Getter;import lombok.Setter;@Entitypublic class ConsolePlayer implements Player {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    private Long id;    public Long getId() {        return id;    }    public void setId(Long id) {        this.id = id;    }    public String getUsername() {        return username;    }    public void setUsername(String username) {        this.username = username;    }    private String username;}