package com.epa.bank.account.service.models.dto;

import java.util.Objects;

public class EventDto {
    String mensaje;

    Object data;

    public EventDto(String mensaje, Object data) {
        this.mensaje = mensaje;
        this.data = data;
    }

    public EventDto() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getData() {
        return  data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
