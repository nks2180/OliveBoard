package com.app.ob.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Created by niranjan on 04/04/17.
 */

@JsonObject
public class Exam {

    @JsonField(name = "exams")
    private List<List<String>> exams;

    public List<List<String>> getExams() {
        return exams;
    }

    public void setExams(List<List<String>> exams) {
        this.exams = exams;
    }
}
