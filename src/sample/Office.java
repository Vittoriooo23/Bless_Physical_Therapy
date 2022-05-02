package sample;

import java.util.ArrayList;

public class Office {

    public static ArrayList<Patient> patients = new ArrayList<>();

    public int findPatient(int id){
        for(int i = 0; i < patients.size(); i++){
            if(patients.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }



}

