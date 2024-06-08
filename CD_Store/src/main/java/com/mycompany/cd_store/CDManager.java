/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cd_store;

/**
 *
 * @author Student
 */
import java.util.HashMap;

public class CDManager {
    private HashMap<String,CD> map = new HashMap<>();

    public CDManager() {
    }

    
    public boolean addCD(CD cd){
        if (map.get(cd.getId())!=null){
            return false;
        }
        map.put(cd.getId(), cd);
        return true;
    }
}

