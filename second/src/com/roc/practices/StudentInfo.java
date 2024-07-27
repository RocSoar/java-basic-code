package com.roc.practices;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class StudentInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 6152209712147496869L;
    public List<Student> list;
    public Map<String, Student> map;

    public StudentInfo(List<Student> list, Map<String, Student> map) {
        this.list = list;
        this.map = map;
    }
}
