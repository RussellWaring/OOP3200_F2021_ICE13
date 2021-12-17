module ca.durhamcollege.oop3200_f2021_ice12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.durhamcollege.oop3200_f2021_ice13 to javafx.fxml;
    exports ca.durhamcollege.oop3200_f2021_ice13;
}