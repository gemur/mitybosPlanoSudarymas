package logic;

import java.util.ArrayList;
import java.util.LinkedList;

public class Diagnosis{
    String diagnosisName;
    String cure;
    public static LinkedList <Diagnosis> diagnoses = new LinkedList<Diagnosis>();
    public static ArrayList<Diagnosis> diagnosesArrayList = new ArrayList<Diagnosis>();

    public Diagnosis(String diagnosisName, String cure){
        this.diagnosisName = diagnosisName;
        this.cure = cure;
        diagnoses.addLast(this);
        diagnosesArrayList.add(this);
    }
    public String getCureFromDiagnosisName(String givenDiagnosisName){
        for (int i = 0 ; i < diagnoses.size() ; i++){
            if(diagnoses.get(i).diagnosisName.equals(givenDiagnosisName)){
                return diagnoses.get(i).getCure();
            }
        }
        return "Tokios ligos nežinome";
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public String getCure() {
        return cure;
    }

    public String toString() {
        return this.diagnosisName;
    }


}