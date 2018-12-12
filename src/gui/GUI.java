package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import logic.*;

import javax.print.Doc;
import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class GUI extends Application {

    Label pusryciaiLabel= new Label("Pusryčiai");
    TextField nameField = new TextField();
    PasswordField passwordField = new PasswordField();
    static String[] user = new String[10];

    private Stage window;
    Font BOLD_FONT = Font.font("Arial", FontWeight.BOLD, 20);
    Font FONT = Font.font("Arial", FontWeight.BOLD, 18);
    int WIDTH = 800;
    int HEIGHT = 500;
    Food food;

    public void init(){
        ReadingFromFile readingFromFile = new ReadingFromFile();
        try {
            readingFromFile.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        GridPane gridPane = createFormPane();
        addStartMenuControls(gridPane);
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);
        window.setScene(scene);
        window.show();

    }


    private void showScene(String scene) {
        GridPane gridPane = createFormPane();
        switch (scene){
            case "menu": {
                addMainMenuControls(gridPane);
                break;
            }
            case "registration":{
                addRegistrationControls(gridPane);
                break;
            }
            case "startmenu":{
                addStartMenuControls(gridPane);
                break;
            }
        }
        Scene menuScene = new Scene(gridPane, WIDTH, HEIGHT);
        window.setScene(menuScene);
        window.show();
    }


    private GridPane createFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();
        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);
        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        return gridPane;
    }


    //Registracijos langas
    private void addRegistrationControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Registracija");
        headerLabel.setFont(BOLD_FONT);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        //Label lytis
        Label lytisLabel = new Label("Lytis : ");
        lytisLabel.setVisible(false);
        gridPane.add(lytisLabel, 0,7);

        //Dropdownas lytis
        ComboBox dropDownLytis = new ComboBox();
        dropDownLytis.getItems().addAll(
                "Vyras",
                "Moteris"
        );
        dropDownLytis.setVisible(false);
        dropDownLytis.setPrefHeight(40);
        gridPane.add(dropDownLytis, 1, 7);

        // Add svoris Label
        Label svorisLabel = new Label("Svoris : ");
        svorisLabel.setVisible(false);
        gridPane.add(svorisLabel, 0, 8);

        // Add svoris Field
        TextField svorisField = new TextField();
        svorisField.setVisible(false);
        svorisField.setPrefHeight(40);
        gridPane.add(svorisField, 1, 8);



        // Add ugis Label
        Label ugisLabel = new Label("Ūgis : ");
        ugisLabel.setVisible(false);
        gridPane.add(ugisLabel, 0, 9);

        // Add ugis Field
        TextField ugisField = new TextField();
        ugisField.setVisible(false);
        ugisField.setPrefHeight(40);
        gridPane.add(ugisField, 1, 9);

        Label roleLabel = new Label("Pasirinkite : ");
        gridPane.add(roleLabel, 0,1);

        //Dropdownas gydytojas ar pacientas
        ComboBox dropDown = new ComboBox();
        dropDown.getItems().addAll(
                "Gydytojas",
                "Pacientas"
        );
        gridPane.add(dropDown, 1, 1);
        dropDown.setOnAction(e -> {
//            System.out.println(dropDown.getItems());
            if (dropDown.getSelectionModel().getSelectedItem().toString().equals("Pacientas")){
                lytisLabel.setVisible(true);
                dropDownLytis.setVisible(true);
                svorisLabel.setVisible(true);
                svorisField.setVisible(true);
                ugisLabel.setVisible(true);
                ugisField.setVisible(true);

            }
            if (dropDown.getSelectionModel().getSelectedItem().toString().equals("Gydytojas")){
                lytisLabel.setVisible(false);
                dropDownLytis.setVisible(false);
                svorisLabel.setVisible(false);
                svorisField.setVisible(false);
                ugisLabel.setVisible(false);
                ugisField.setVisible(false);

            }
        });

        // Add Name Label
        Label nameLabel = new Label("Vardas : ");
        gridPane.add(nameLabel, 0,2);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,2);

        // Add Last Name Label
        Label lastNameLabel = new Label("Pavardė : ");
        gridPane.add(lastNameLabel, 0,3);

        // Add Last Name Text Field
        TextField lastNameField = new TextField();
        lastNameField.setPrefHeight(40);
        gridPane.add(lastNameField, 1,3);


        // Add Email Label
        Label emailLabel = new Label("El. paštas : ");
        gridPane.add(emailLabel, 0, 4);

        // Add Email Text Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 4);

        // Add Password Label
        Label passwordLabel = new Label("Slaptažodis : ");
        gridPane.add(passwordLabel, 0, 5);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 5);

        // Add Password2 Label
        Label passwordLabel2 = new Label("Pakartokite slaptažodį : ");
        gridPane.add(passwordLabel2, 0, 6);

        // Add Password2 Field
        PasswordField passwordField2 = new PasswordField();
        passwordField2.setPrefHeight(40);
        gridPane.add(passwordField2, 1, 6);



        // Add Submit Button
        Button submitButton = new Button("Patvirtinti");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 10, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(dropDown.getSelectionModel().getSelectedItem().toString().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Klaida!", "Pasirinkite rolę");
                    return;
                }
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Klaida!", "Įveskite vardą");
                    return;
                }
                if(lastNameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Klaida!", "Įveskite pavardę");
                    return;
                }
                if(emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Klaida!", "Įveskite el. pašto adresą");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Klaida!", "Įveskite slaptažodį");
                    return;
                }

                // IRASYMAS I FAILA DOCTOR / PATIENT
                if(dropDown.getSelectionModel().getSelectedItem().toString().equals("Gydytojas")){
                    Doctor doctor = new Doctor(emailField.getText(), passwordField.getText(), nameField.getText(), lastNameField.getText());
                    WritingToFile f = new WritingToFile();
                    try {
                        f.writeDoctor(doctor);
                    } catch (IOException e) {
                        showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Klaida!", "Klaida įrašant į failą");
                        return;
                    }
                }
                else if(dropDown.getSelectionModel().getSelectedItem().toString().equals("Pacientas")){
                    Patient patient = new Patient(emailField.getText(), passwordField.getText(), nameField.getText(), lastNameField.getText(),
                            dropDownLytis.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(ugisField.getText()), Integer.parseInt(svorisField.getText()));
                    WritingToFile f = new WritingToFile();
                    try {
                        f.writePatient(patient);
                    } catch (IOException e) {
                        showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Klaida!", "Klaida įrašant į failą");
                        return;
                    }
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Sveikiname", "Registracija sėkminga! ");
                showScene("startmenu");
            }
        });


        Button closeBTN = new Button("Grįžti");
        closeBTN.setPrefHeight(40);
        closeBTN.setDefaultButton(true);
        closeBTN.setPrefWidth(100);
        gridPane.add(closeBTN, 0, 11, 2, 1);
        GridPane.setHalignment(closeBTN, HPos.CENTER);
        closeBTN.setOnAction(e -> {
            try {
                start(window);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
    private void addStartMenuControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Mitybos plano sudarymo sistema");
        headerLabel.setFont(BOLD_FONT);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);

        // Add Name Label
        Label eMailLabel = new Label("El. paštas : ");
        eMailLabel.setPrefHeight(40);
        gridPane.add(eMailLabel, 0,1);

        // Add Name Text Field

        gridPane.add(nameField, 1,1);


        // Add Password Label
        Label passwordLabel = new Label("Slaptažodis : ");
        passwordLabel.setPrefHeight(40);
        gridPane.add(passwordLabel, 0, 2);

        // Add Password Field
        gridPane.add(passwordField, 1, 2);



        Button loginBTN = new Button("Prisijungti");
        loginBTN.setPrefHeight(40);
        loginBTN.setDefaultButton(true);
        loginBTN.setPrefWidth(100);
        gridPane.add(loginBTN, 0, 3, 2, 1);
        GridPane.setHalignment(loginBTN, HPos.CENTER);
        loginBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Formos klaida!", "Iveskite el. paštą");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Formos klaida!", "Iveskite slaptazodi");
                    return;
                }else {
                    doLogin();
                }
            }
        });

        Button registerBTN = new Button("Registruotis");
        registerBTN.setPrefHeight(40);
        registerBTN.setDefaultButton(true);
        registerBTN.setPrefWidth(100);
        gridPane.add(registerBTN, 0, 4, 2, 1);
        GridPane.setHalignment(registerBTN, HPos.CENTER);
        registerBTN.setOnAction(e -> showScene("registration"));

//        Button closeBTN = new Button("Išjungti");
//        closeBTN.setPrefHeight(40);
//        closeBTN.setDefaultButton(true);
//        closeBTN.setPrefWidth(100);
//
//        gridPane.add(closeBTN, 0, 5, 2, 1);
//        GridPane.setMargin(closeBTN, new Insets(20, 0,20,0));
//        GridPane.setHalignment(closeBTN, HPos.CENTER);
//        closeBTN.setOnAction(e -> closeProgram());

    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }


    private void closeProgram() {
        window.close();
    }

    private void doLogin() {
        boolean loggedIn = false;

        Patient tempo = new Patient(nameField.getText(),passwordField.getText());

        for(int i = 0; i < tempo.patients.size(); i++){

            if (tempo.patients.get(i).getEmail().equals(nameField.getText()) && tempo.patients.get(i).getPassword().equals(passwordField.getText())){
                user[0] = "Pacientas";
                user[1] = tempo.patients.get(i).getName();
                user[2] = tempo.patients.get(i).getLastName();
                user[4] = tempo.patients.get(i).getKMI();
                loggedIn = true;
                showScene("menu");
            }
        }

        Doctor temp = new Doctor(nameField.getText(),passwordField.getText());
        for(int i = 0; i < temp.doctors.size(); i++){
            //System.out.println(temp.doctors.get(i).getEmail());

            if (temp.doctors.get(i).getEmail().equals(nameField.getText()) && temp.doctors.get(i).getPassword().equals(passwordField.getText())){
                user[0] = "Gydytojas";
                user[1] = temp.doctors.get(i).getName();
                user[2] = temp.doctors.get(i).getLastName();
                loggedIn = true;
                showScene("menu");
            }
        }

        if(loggedIn == false){
            showAlert(Alert.AlertType.ERROR, window,"Klaida!", "Neteisingas el. paštas arba slaptažodis");

        }
    }



    private void addMainMenuControls(GridPane gridPane) {


        //Label kas yra prisijunges


        Label kasPrisijengesLabel = new Label(user[0] + ": " + user[1] + " " + user[2]);
        kasPrisijengesLabel.setFont(BOLD_FONT);
        gridPane.add(kasPrisijengesLabel, 0,0,2,1);
        GridPane.setHalignment(kasPrisijengesLabel, HPos.LEFT);

        //Mygtukas atsijungti
        Button atsijuntiBTN = new Button("Atsijungti");
        atsijuntiBTN.setPrefHeight(40);
        atsijuntiBTN.setDefaultButton(true);
        atsijuntiBTN.setPrefWidth(100);
        gridPane.add(atsijuntiBTN, 2, 0);
        GridPane.setValignment(atsijuntiBTN, VPos.TOP);
        GridPane.setHalignment(atsijuntiBTN, HPos.RIGHT);
        atsijuntiBTN.setOnAction(e -> showScene("startmenu"));

        if(user[0].equals("Gydytojas")){
            Label pacientasLabel = new Label("Pacientas : ");
            gridPane.add(pacientasLabel, 0,1);

            //Dropdownas pasirinkti pacienta
            ComboBox patientDropDown = new ComboBox();
            patientDropDown.getItems().addAll(Patient.patientsArrayList);
            gridPane.add(patientDropDown, 1, 1);

            Label diagnosisLabel = new Label("Diagnoze : ");
            diagnosisLabel.setVisible(false);
            gridPane.add(diagnosisLabel, 0,2);



            Label weightLabel = new Label("Svoris : ");
            weightLabel.setVisible(false);
            gridPane.add(weightLabel, 0,3);

            TextField weightField = new TextField();
            weightField.setVisible(false);
            weightField.setPrefHeight(40);
            weightField.setDisable(true);
            gridPane.add(weightField, 1, 3, 1, 1);

            Button redaguotiWeight = new Button("Redaguoti");
            redaguotiWeight.setPrefHeight(40);
            redaguotiWeight.setDefaultButton(true);
            redaguotiWeight.setPrefWidth(100);
            redaguotiWeight.setVisible(false);
            gridPane.add(redaguotiWeight, 2, 3, 1, 1);
            GridPane.setHalignment(redaguotiWeight, HPos.RIGHT);
            redaguotiWeight.setOnAction(e -> weightField.setDisable(false));

            Label heightLabel = new Label("Ugis : ");
            heightLabel.setVisible(false);
            heightLabel.setPrefHeight(40);
            gridPane.add(heightLabel, 0,4);



            TextField heightField = new TextField();
            heightField.setVisible(false);
            heightField.setPrefHeight(40);
            heightField.setDisable(true);
            gridPane.add(heightField, 1, 4, 1, 1);


            Button redaguotiHeight = new Button("Redaguoti");
            redaguotiHeight.setPrefHeight(40);
            redaguotiHeight.setDefaultButton(true);
            redaguotiHeight.setPrefWidth(100);
            redaguotiHeight.setVisible(false);
            gridPane.add(redaguotiHeight, 2, 4, 1, 1);
            GridPane.setHalignment(redaguotiHeight, HPos.RIGHT);
            redaguotiHeight.setOnAction(e -> heightField.setDisable(false));

            Label kmiLabel = new Label("KMI : ");
            kmiLabel.setVisible(false);
            gridPane.add(kmiLabel, 0,5);


            Label kmiLabel2 = new Label("0.00");
            kmiLabel2.setVisible(false);
            gridPane.add(kmiLabel2, 1,5);

            Button getMeniu = new Button("Gauti meniu");
            getMeniu.setPrefHeight(40);
            getMeniu.setVisible(false);
            getMeniu.setDefaultButton(true);
            getMeniu.setPrefWidth(150);
            gridPane.add(getMeniu, 1, 6, 1, 1);
            GridPane.setHalignment(getMeniu, HPos.CENTER);

            patientDropDown.setOnAction(e -> {
                Patient patient = (Patient) patientDropDown.getSelectionModel().getSelectedItem();
                pusryciaiLabel.setVisible(false);
                diagnosisLabel.setVisible(true);
                heightField.setDisable(true);
                weightField.setDisable(true);
                weightLabel.setVisible(true);
                weightField.setText(String.valueOf(patient.getWeight()));
                weightField.setVisible(true);
                redaguotiWeight.setVisible(true);
                redaguotiHeight.setVisible(true);
                getMeniu.setVisible(true);
                heightLabel.setVisible(true);
                heightField.setText(String.valueOf(patient.getHeight()));
                heightField.setVisible(true);
                kmiLabel.setVisible(true);
                kmiLabel2.setText(String.valueOf(patient.getKMI()));
                kmiLabel2.setFont(FONT);
                if(Double.parseDouble(kmiLabel2.getText()) < 18.5 || Double.parseDouble(kmiLabel2.getText()) > 30.0){
                    kmiLabel2.setTextFill(Color.web("#FF0000"));
                }else if(Double.parseDouble(kmiLabel2.getText()) > 24.9){
                    kmiLabel2.setTextFill(Color.web("#FF8300"));
                }else{
                    kmiLabel2.setTextFill(Color.web("#0B6623"));
                }
                kmiLabel2.setVisible(true);

                //Dropdownas pasirinkti diagnoze
                ComboBox diagnosisCombobox = new ComboBox();
                diagnosisCombobox.getItems().addAll(patient.getDiagnosis());
                diagnosisCombobox.getItems().addAll(Diagnosis.diagnosesArrayList);
                diagnosisCombobox.getSelectionModel().selectFirst();
                diagnosisCombobox.setVisible(true);
                gridPane.add(diagnosisCombobox, 1 ,2 );


                Button saveChanges = new Button("Išsaugoti pakeitimus");
                saveChanges.setPrefHeight(40);
                saveChanges.setDefaultButton(true);
                saveChanges.setPrefWidth(125);
                saveChanges.setVisible(true);
                gridPane.add(saveChanges, 2, 5, 1, 1);
                GridPane.setHalignment(saveChanges, HPos.RIGHT);
                saveChanges.setOnAction(d -> {
                        saveChanges(patient, Integer.parseInt(weightField.getText()), Integer.parseInt(heightField.getText()), (Diagnosis) diagnosisCombobox.getSelectionModel().getSelectedItem());
                        showScene("menu");
                        }
                );

                Label pusryciaiLabel = new Label("Pusryčiai: ");
                pusryciaiLabel.setVisible(false);
                pusryciaiLabel.setFont(BOLD_FONT);
                pusryciaiLabel.setPrefWidth(150);
                gridPane.add(pusryciaiLabel,0,8);

                Label pietusLabel = new Label("Pietūs: ");
                pietusLabel.setVisible(false);
                pietusLabel.setFont(BOLD_FONT);
                pietusLabel.setPrefWidth(150);
                gridPane.add(pietusLabel,0,9);


                Diagnosis diagnosis = patient.getDiagnosis();


                getMeniu.setOnAction(d ->  {
                    String diagnozesPav = diagnosis.getDiagnosisName();
                    String reikalingasDalykas = diagnosis.getCureFromDiagnosisName(diagnozesPav);//baltymai angliavandeniai kolorijos
                    //System.out.println(reikalingasDalykas);
                    ArrayList<Food> tinkamasMaistasPusryciams = Food.rastiReiklingaMaista(reikalingasDalykas,Double.parseDouble(patient.getKMI()), "forBreakfast" );
                    ArrayList<Food> tinkamasMaistasNePusryciams = Food.rastiReiklingaMaista(reikalingasDalykas,Double.parseDouble(patient.getKMI()), "0" );
                    // System.out.println(tinkamasMaistasPusryciams);
                    //System.out.println(tinkamasMaistasNePusryciams);

                    ComboBox pusryciuMenu = new ComboBox();
                    pusryciuMenu.getItems().addAll(tinkamasMaistasPusryciams);
                    pusryciuMenu.getSelectionModel().selectFirst();
                    pusryciuMenu.setVisible(true);
                    gridPane.add(pusryciuMenu, 1 ,8 );

                    ComboBox pietuMenu = new ComboBox();
                    pietuMenu.getItems().addAll(tinkamasMaistasNePusryciams);
                    pietuMenu.getSelectionModel().selectFirst();
                    pietuMenu.setVisible(true);
                    gridPane.add(pietuMenu, 1 ,9 );


                    pusryciaiLabel.setVisible(true);
                    pietusLabel.setVisible(true);
                });




            });


            //Patient GUI
        }else{

            Patient patient = Patient.findPatient(nameField.getText(),passwordField.getText());
            Label diagnosisLabel = new Label("Diagnozė : ");
            diagnosisLabel.setFont(FONT);
            gridPane.add(diagnosisLabel, 0,2);

            Label diagnosisLabel2 = new Label(patient.getDiagnosisString());
            diagnosisLabel2.setFont(FONT);
            gridPane.add(diagnosisLabel2, 1,2);



            Label kmiLabel = new Label("KMI : ");
            kmiLabel.setFont(FONT);
            gridPane.add(kmiLabel,0,3);

            Label kmiLabel2 = new Label(String.valueOf(patient.getKMI()));
            kmiLabel2.setFont(FONT);
            if(Double.parseDouble(patient.getKMI()) < 18.5 || Double.parseDouble(patient.getKMI()) > 30){
                kmiLabel2.setTextFill(Color.web("#FF0000"));
            }else if(Double.parseDouble(patient.getKMI()) > 24.9){
                kmiLabel2.setTextFill(Color.web("#FF8300"));
            }else{
                kmiLabel2.setTextFill(Color.web("#0B6623"));
            }
            gridPane.add(kmiLabel2, 1,3);


            Label pusryciaiLabel = new Label("Pusryčiai: ");
            pusryciaiLabel.setVisible(false);
            pusryciaiLabel.setFont(BOLD_FONT);
            pusryciaiLabel.setPrefWidth(150);
            gridPane.add(pusryciaiLabel,0,8);

            Label pietusLabel = new Label("Pietūs: ");
            pietusLabel.setVisible(false);
            pietusLabel.setFont(BOLD_FONT);
            pietusLabel.setPrefWidth(150);
            gridPane.add(pietusLabel,0,9);


            Diagnosis diagnosis = patient.getDiagnosis();

            Button getMeniu = new Button("Gauti meniu");
            getMeniu.setPrefHeight(40);
            getMeniu.setVisible(true);
            getMeniu.setDefaultButton(true);
            getMeniu.setPrefWidth(150);
            gridPane.add(getMeniu, 1, 6, 1, 1);
            GridPane.setHalignment(getMeniu, HPos.CENTER);
            getMeniu.setOnAction(d ->  {
                String diagnozesPav = diagnosis.getDiagnosisName();
                String reikalingasDalykas = diagnosis.getCureFromDiagnosisName(diagnozesPav);//baltymai angliavandeniai kolorijos
                //System.out.println(reikalingasDalykas);
                ArrayList<Food> tinkamasMaistasPusryciams = Food.rastiReiklingaMaista(reikalingasDalykas,Double.parseDouble(patient.getKMI()), "forBreakfast" );
                ArrayList<Food> tinkamasMaistasNePusryciams = Food.rastiReiklingaMaista(reikalingasDalykas,Double.parseDouble(patient.getKMI()), "0" );
                // System.out.println(tinkamasMaistasPusryciams);
                //System.out.println(tinkamasMaistasNePusryciams);

                ComboBox pusryciuMenu = new ComboBox();
                pusryciuMenu.getItems().addAll(tinkamasMaistasPusryciams);
                pusryciuMenu.getSelectionModel().selectFirst();
                pusryciuMenu.setVisible(true);
                gridPane.add(pusryciuMenu, 1 ,8 );

                ComboBox pietuMenu = new ComboBox();
                pietuMenu.getItems().addAll(tinkamasMaistasNePusryciams);
                pietuMenu.getSelectionModel().selectFirst();
                pietuMenu.setVisible(true);
                gridPane.add(pietuMenu, 1 ,9 );


                pusryciaiLabel.setVisible(true);
                pietusLabel.setVisible(true);
            });

        }

        gridPane.setAlignment(Pos.TOP_CENTER);
    }

    private void saveChanges(Patient patient, int weight, int height, Diagnosis diagnosis) {
        patient.setHeight(height);
        patient.setDiagnosis(diagnosis);
        patient.setWeight(weight);

    }

    private void writePatientData(Patient patient, String height, String weight ) {

    }


}