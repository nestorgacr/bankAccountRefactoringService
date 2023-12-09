package com.epa.bank.account.service.models.mongo;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Objects;

@Document("Error")
public class ErrorMongo
{
    @Id
    private String id;
    private String Message;

    @CreatedDate
    @Field("Created")
    private Date Created;


    public ErrorMongo(String id, String message,  Date created) {
        this.id = id;
        Message = message;
        Created = created;
    }

    public ErrorMongo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }



    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date created) {
        Created = created;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorMongo that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(Message, that.Message) && Objects.equals(Created, that.Created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Message, Created);
    }
}
