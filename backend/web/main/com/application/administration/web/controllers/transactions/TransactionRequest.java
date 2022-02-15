package com.application.administration.web.controllers.transactions;

public class TransactionRequest {

    private  String from;
    private  String to;
    private  Integer quantity;

    public TransactionRequest(String from, String to, Integer quantity) {
        this.from = from;
        this.to = to;
        this.quantity = quantity;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
