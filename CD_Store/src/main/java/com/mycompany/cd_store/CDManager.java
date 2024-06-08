/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cd_store;

/**
 *
 * @author Student
 */
import java.util.ArrayList;
import java.util.HashMap;

public class CDManager {

    private HashMap<String, CD> map = new HashMap<>();
    private ArrayList<CD> list = new ArrayList<>();

    public CDManager() {
    }

    public boolean addCD(CD cd) {
        if (map.get(cd.getId()) != null) {
            return false;
        }
        list.add(cd);
        map.put(cd.getId(), cd);
        return true;
    }

    public void removeCD(int pos) {
        map.remove(list.get(pos).getId());
        list.remove(pos);
    }

    public ArrayList<CD> searchBy(String type, String para) {
        ArrayList<CD> returnList = new ArrayList<>();
        switch (type) {
            case "Title": {
                for (CD cd : list) {
                    if (cd.getTitle().equals(para)) {
                        returnList.add(cd);
                    }
                }
            }

            break;
            case "Collection": {
                for (CD cd : list) {
                    if (cd.getCollection().equals(para)) {
                        returnList.add(cd);
                    }
                }
            }

            break;
            case "Type": {
                for (CD cd : list) {
                    if (cd.getType().equals(para)) {
                        returnList.add(cd);
                    }
                }
            }

            break;
            case "Price": {
                for (CD cd : list) {
                    if (Double.compare(cd.getPrice(), Double.parseDouble(para)) == 0) {
                        returnList.add(cd);
                    }
                }
            }

            break;
            default:
                throw new AssertionError();
        }
        return returnList;
    }

    public ArrayList<CD> getCDList() {
        return list;
    }
}
