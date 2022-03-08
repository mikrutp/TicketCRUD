package com.example.ciscoTask.model;

import javax.persistence.*;

@Entity
@Table
public class CaseTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    private String title;
    private String description;
    private String severity;
    private String status;

    public CaseTicket() {
    }

    public CaseTicket(String title, String description, String severity, String status) {
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
