package sample;

import sample.Patient;

import java.sql.*;
import java.util.ArrayList;

import static sample.Office.patients;

public class MyJDBC {

    private ArrayList<Integer> ids = new ArrayList<>();

    public MyJDBC() {
        retrieveData();
    }

    private String getSmallestId() {
        int i;
        for (i = 0; i < ids.size(); i++) {
            if (ids.get(i) != (i + 1)) {
                ids.add(i+1);
                return Integer.toString(i+1);
            }
        }
        return Integer.toString(i+1);
    }


    public void addPatientToDB(Patient patient) throws Exception{
        String id = getSmallestId();
        patient.setId(Integer.parseInt(id));
        String query = "insert into meachampatient values (" +
                "\"" + patient.getName() +  "\", " +
                "\"" + patient.getAddress() + "\", " +
                "\"" + patient.getDoa() + "\", " +
                "\"" + patient.getDob() + "\", " +
                "\"" + patient.getParts() + "\", " +
                "\"" + patient.getCount() + "\", " +
                "\"" + id + "\");";

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blessphystherapypatients", "root", "blessTherapy");

        Statement statement = conn.createStatement();

        statement.executeUpdate(query);
        patients.add(patient);
        ids.add(patient.getId());
        conn.close();



    }

    public void deletePatientFromDB(int id){

        String query = "delete from patient where id = " + id;
        Office office = new Office();
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blessphystherapypatients", "root", "blessTherapy");

            Statement statement = conn.createStatement();

            statement.executeUpdate(query);

            patients.remove(office.findPatient(id));
            ids.remove(ids.indexOf(id));
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void retrieveData(){

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blessphystherapypatients", "root", "blessTherapy");

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from meachampatient");

            while(resultSet.next()){
                patients.add(new Patient(
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("doa"),
                        resultSet.getString("dob"),
                        resultSet.getString("parts"),
                        resultSet.getInt("count"),
                        resultSet.getInt("id")
                        )
                );
                ids.add(resultSet.getInt("id"));

            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
