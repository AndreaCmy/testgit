package com.cmy.controller.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengyingc on 2017/4/28.
 */
public class YoungGenGC {

    static class OOMObject{}
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
