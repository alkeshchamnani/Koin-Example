package com.alkesh.koinexample.core.models.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TaskModel implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("task")
    @Expose
    private String task;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}