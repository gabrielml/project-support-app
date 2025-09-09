package dev.gml.project_support_app.supportrequest;// Entity (Model)

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name="support_requests") // It should match  my diagram's table name.
public class SupportRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_support_request")
    private Long id;

    @NotBlank(message = "Requester name is mandatory!")
    @Column(name = "requester_name", nullable = false) // Maps to column name
    private String requesterName;

    @NotNull
    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate;

    @NotBlank(message = "Description is mandatory!")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @NotBlank
    @Column(nullable = false)
    private String status = "PENDING"; // This is the default value.

    @Column(name = "attended_by")
    private String attendedBy; // Simple String, as designed.

    @Column(name = "support_date")
    private LocalDateTime supportDate;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    // The Relationship - This is the Foreign Key from my diagram.
    @NotNull(message = "Query topic is mandatory!")
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_query_topic", nullable = false) // Name of the FK column.
    private QueryTopic queryTopic;

    // Constructors
    public SupportRequest() {

    }

    // Constructor for creating a new request
    public SupportRequest(String requesterName, LocalDateTime requestDate, String description, QueryTopic queryTopic){
        this.requesterName = requesterName;
        this.requestDate = requestDate;
        this.description = description;
        this.queryTopic = queryTopic;
    }

    // Getters & Setters for all fields
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getRequesterName(){
        return requesterName;
    }

    public void setRequesterName(String requesterName){
        this.requesterName = requesterName;
    }

    public LocalDateTime getRequestDate(){
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate){
        this.requestDate = requestDate;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getAttendedBy(){
        return attendedBy;
    }

    public void setAttendedBy(String attendedBy){
        this.attendedBy = attendedBy;
    }

    public LocalDateTime getSupportDate(){
        return supportDate;
    }

    public void setSupportDate(LocalDateTime supportDate){
        this.supportDate = supportDate;
    }

    public LocalDateTime getLastModifiedDate(){
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate){
        this.lastModifiedDate = lastModifiedDate;
    }

    public QueryTopic getQueryTopic(){
        return queryTopic;
    }

    public void setQueryTopic(QueryTopic queryTopic) {
        this.queryTopic = queryTopic;
    }

}