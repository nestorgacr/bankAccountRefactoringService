package com.epa.bank.account.service.models.mongo;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Objects;

@Document("Log")
public class LogMongo
{
    @Id
    private String id;
    private String Message;
    private Object Data;

    @CreatedDate
    @Field("Created")
    private Date Created;


    public LogMongo(String id, String message, Object data, Date created) {
        this.id = id;
        Message = message;
        Data = data;
        Created = created;
    }

    public LogMongo() {
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

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
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
        if (o == null || getClass() != o.getClass()) return false;
        LogMongo logMongo = (LogMongo) o;
        return Objects.equals(id, logMongo.id) && Objects.equals(Message, logMongo.Message) && Objects.equals(Data, logMongo.Data) && Objects.equals(Created, logMongo.Created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Message, Data, Created);
    }
}
