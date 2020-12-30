package com.alkesh.koinexample.core.models.response;

import com.alkesh.koinexample.core.models.dto.TaskModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MyTaskApiResponse {

    @Expose
    @SerializedName("data")
    public ArrayList<TaskModel> data;
}