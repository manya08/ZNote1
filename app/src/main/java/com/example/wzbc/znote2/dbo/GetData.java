package com.example.wzbc.znote2.dbo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WZBC on 2018/4/11.
 */

public class GetData {
    public static List<Map<String,Object>> getMyData(){
        List<Map<String,Object>> list =new ArrayList<>();

        Map<String,Object> map =new HashMap<>();
        map.put("title","G1");
        map.put("info","google 1");
        map.put("data","2017 2 18");
        list.add(map);

        map =new HashMap<>();
        map.put("title","G2");
        map.put("info","google 1");
        map.put("data","2017 2 18");
        list.add(map);

        map =new HashMap<>();
        map.put("title","G3");
        map.put("info","google 1");
        map.put("data","2017 2 18");
        list.add(map);
        return  list;
    }
}
