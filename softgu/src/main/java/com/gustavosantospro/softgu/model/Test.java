package com.gustavosantospro.softgu.model;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> example = new HashMap<String,String>();

        example.put("K1", new String("V1"));
        example.put("K2", new String("V2"));
        example.put("K3", new String("V3"));

        String stringToSearch = "K3";

        if (example.containsKey(stringToSearch)) {
            System.out.println("valor da chave " + stringToSearch + "= " + example.get(stringToSearch));
        } else {
            System.err.println("key dont exist");
        }
    }
}
