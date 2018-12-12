package logic;

import java.util.ArrayList;
import java.util.LinkedList;

public class Patient  {
    String name;
    String lastName;
    String password;
    String email;
    String gender;
    int height;
    int weight;
    Diagnosis diagnosis;
    public static LinkedList<Patient> patients = new LinkedList<>();
    public static ArrayList <Patient> patientsArrayList = new ArrayList<>();


    public Patient (String email, String password, String name, String lastName, String gender, int height, int weight){
        this.diagnosis = Diagnosis.diagnoses.get(0);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        patients.addLast(this);
        patientsArrayList.add(this);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Patient(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
    public String getDiagnosisString() {
        return diagnosis.diagnosisName;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String toString() {
        return this.email + " " + this.password + " " + this.name + " " + this.lastName + " " + this.gender + " " + this.height + " " + this.weight;
    }

    public String getEmail() {
        return email;
    }

    public static Patient findPatient (String email, String password ){
        for (int i = 0 ; i < patientsArrayList.size() ; i++){
            if (patientsArrayList.get(i).getEmail().equals(email) && patientsArrayList.get(i).getPassword().equals(password)){
                return patientsArrayList.get(i);
            }
        }
        return null;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getKMI() {
        Double value = weight / ((double)height *(double)height)*10000;
        return String.valueOf((double)Math.round(value * 10d) / 10d);
    }

    public String getLastName() {
        return lastName;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

}
