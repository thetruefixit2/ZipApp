package com.daniilbelevtsev.zipapp.ui.events;


/**
 * Created by Daniil Belevtsev on 21.11.2016 22:13.
 * Project: ZipApp; Skype: pandamoni1
 */

public class Event<D> {
    private Operation operation;
    private D data;

    public Event(Operation operation, D data) {
        this.operation = operation;
        this.data = data;
    }

    public Operation getOperation() {
        return operation;
    }

    public D getData() {
        return data;
    }
}
