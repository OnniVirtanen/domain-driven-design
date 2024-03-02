package com.paymentservice.demo.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    protected Date createdAt;
    protected Date updatedAt;

    protected BaseEntity() {}

    @PrePersist
    protected void prePersist() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    protected Date getCreatedAt() {
        return createdAt;
    }

    protected Date getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    protected void preUpdate() {
        updatedAt = new Date();
    }

}
