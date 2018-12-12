package logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.zip.DeflaterOutputStream;

public class Food{
    String productName;
    double carbohydrate;
    double protein;
    int calories;
    String isForBreakfast;

    public static ArrayList<Food> foods = new ArrayList<>();

    public Food(String productName, double carbohydrate, double protein, int calories, String isForBreakfast){
        this.productName = productName;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.calories = calories;
        this.isForBreakfast = isForBreakfast;
        foods.add(this);
    }

    public int getCalories() {
        return calories;
    }

    public static ArrayList <Food> rastiReiklingaMaista(String medziagos, double kmi, String pusryciams){
//        System.out.println(medziagos + " " + kmi);
        ArrayList <Food> gerasMaistas = new ArrayList<>();
        int kalorijuvid = kalorijuVidurkis();
        if (medziagos.equals("baltymai")){
            for (int i = 0 ; i < foods.size() ; i++){
                if (foods.get(i).protein>foods.get(i).carbohydrate ){
                    //System.out.println(kmi + "  "  + foods.get(i).getCalories() + "  " + kalorijuvid);
                    if (kmi<18.5 && foods.get(i).getCalories()>kalorijuvid){
                        if (pusryciams.equals("forBreakfast") && foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                        if (!pusryciams.equals("forBreakfast") && !foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                    }
                    if (kmi>25 && foods.get(i).getCalories()<kalorijuvid){
                        if (pusryciams.equals("forBreakfast") && foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                        if (!pusryciams.equals("forBreakfast") && !foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                    }
                    if (kmi>=18.5 && kmi <= 25) {
                        if (pusryciams.equals("forBreakfast") && foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                        if (!pusryciams.equals("forBreakfast") && !foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                    }

                }
            }
        }
        if (medziagos.equals("angliavandeniai")){
            for (int i = 0 ; i < foods.size() ; i++){
                if (foods.get(i).protein<foods.get(i).carbohydrate ){
//                    System.out.println(foods.get(i));
//                    System.out.println(kmi + "  "  + foods.get(i).getCalories() + "  " + kalorijuvid);
//                    System.out.println();
                    if (kmi<18.5 && foods.get(i).getCalories()>kalorijuvid){
                        if (pusryciams.equals("forBreakfast") && foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                        if (!pusryciams.equals("forBreakfast") && !foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                    }
                    if (kmi>25 && foods.get(i).getCalories()<kalorijuvid){
                        if (pusryciams.equals("forBreakfast") && foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                        if (!pusryciams.equals("forBreakfast") && !foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                    }
                    if (kmi>=18.5 && kmi <= 25) {
                        if (pusryciams.equals("forBreakfast") && foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                        if (!pusryciams.equals("forBreakfast") && !foods.get(i).isForBreakfast.equals("forBreakfast")){
                            gerasMaistas.add(foods.get(i));
                        }
                    }

                }
            }
        }
        if (medziagos.equals("Norma")){
            for (int i = 0 ; i < foods.size() ; i++){
//                System.out.println(foods.get(i));
//                System.out.println(kmi + "  "  + foods.get(i).getCalories() + "  " + kalorijuvid);
//                System.out.println();
                if (kmi<18.5 && foods.get(i).getCalories()>kalorijuvid){
                    if (pusryciams.equals("forBreakfast") && foods.get(i).isForBreakfast.equals("forBreakfast")){
                        gerasMaistas.add(foods.get(i));
                    }
                    if (!pusryciams.equals("forBreakfast") && !foods.get(i).isForBreakfast.equals("forBreakfast")){
                        gerasMaistas.add(foods.get(i));
                    }
                }
                if (kmi>25 && foods.get(i).getCalories()<kalorijuvid){
                    if (pusryciams.equals("forBreakfast") && foods.get(i).isForBreakfast.equals("forBreakfast")){
                        gerasMaistas.add(foods.get(i));
                    }
                    if (!pusryciams.equals("forBreakfast") && !foods.get(i).isForBreakfast.equals("forBreakfast")){
                        gerasMaistas.add(foods.get(i));
                    }
                }
                if (kmi>=18.5 && kmi <= 25) {
                    if (pusryciams.equals("forBreakfast") && foods.get(i).isForBreakfast.equals("forBreakfast")){
                        gerasMaistas.add(foods.get(i));
                    }
                    if (!pusryciams.equals("forBreakfast") && !foods.get(i).isForBreakfast.equals("forBreakfast")){
                        gerasMaistas.add(foods.get(i));
                    }
                }
            }
        }
        return gerasMaistas;
    }

    public static int kalorijuVidurkis(){
        int suma = 0;
        for (int i= 0 ; i<foods.size();i++){
            //System.out.println(foods.get(i).getCalories());
            suma = suma + foods.get(i).getCalories();
            //System.out.println(suma);
        }
        return suma/foods.size();
    }



    @Override
    public String toString() {
        return this.productName+","+this.carbohydrate+","+this.protein+","+this.calories+","+this.isForBreakfast;
    }
}