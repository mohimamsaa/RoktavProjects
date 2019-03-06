package com.sisi.reimbursement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table (name = "reimburse")
public class BisulModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Size(max = 255)
    @Column(name = "item", nullable = false)
    private String item;

    @NotNull
    @Column(name = "nominal", nullable = false)
    private Double nominal;

    @NotNull
    @Size(max = 255)
    @Column(name = "contacts", nullable = false)
    private String contacts;

    @NotNull
    @Size(max = 255)
    @Column(name = "division", nullable = false)
    private String division;

    @NotNull
    @Size(max = 255)
    @Column(name = "project", nullable = false)
    private String project;

    @NotNull
    @Size(max = 255)
    @Column(name = "dateOfTransaction", nullable = false)
    private String dateOfTransaction;

    @NotNull
    @Size(max = 255)
    @Column(name = "needs", nullable = false)
    private String needs;

    @NotNull
    @Size(max = 255)
    @Column(name = "status", nullable = false)
    private String status;

    @Size(max = 255)
    @Column(name = "notes")
    private String notes;

    @Size(max = 255)
    @Column(name = "feedback")
    private String feedback;

    @Size(max = 255)
    @Column(name = "preferredBank", nullable = false)
    private String preferredBank;

    @Size(max = 255)
    @Column(name = "accNumber", nullable = false)
    private String accNumber;

    @Size(max = 255)
    @Column(name = "proof")
    private String proof;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNominal() {
        return nominal;
    }

    public void setNominal(Double nominal) {
        this.nominal = nominal;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(String dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPreferredBank() {
        return preferredBank;
    }

    public void setPreferredBank(String preferredBank) {
        this.preferredBank = preferredBank;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }
}
