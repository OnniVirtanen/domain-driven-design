package com.paymentservice.demo.domain;

import java.util.Date;

/**
 * Domain objects are for handling business logic. They don't know anything about persistence.
 */
public abstract class DomainObject {

    protected Date createdAt;
    protected Date updatedAt;

    protected DomainObject() {}

    protected Date getCreatedAt() {
        return createdAt;
    }

    protected Date getUpdatedAt() {
        return updatedAt;
    }

}
