package com.neuron.etl.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: FengJie
 * #Description: CourseList
 * #Date: 2021/5/8 21:37
 */
public class CourseList {
    private String[] lsit;
    private int i = -1;
    private Map<String, Object> stringObjectMap = null;

    public CourseList(String son) {
        stringObjectMap = new HashMap<>();
        lsit = publicData.COURSE_NAMES;
        stringObjectMap.put(lsit[++i], son);
    }

    public Map<String, Object> getStringObjectMap() {
        return stringObjectMap;
    }

    public void geuCousre(String s) {
        String s1 = s.substring(1, s.length() - 1);
        String[] p={"\"","'"};
        for (String s2 : p) {
            s1=s1.replace(s2,"");
        }
        String[] str=s1.split(", ");
        if (i == lsit.length - 1) {
            return;
        }
        for (String string : str) {
            stringObjectMap.put(lsit[++i], string);
        }
    }
}
