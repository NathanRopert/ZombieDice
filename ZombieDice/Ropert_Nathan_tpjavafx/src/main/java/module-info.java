module com.example.ropert_nathan_tpjavafx {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.ropert_nathan_tpjavafx to javafx.fxml;
    exports com.example.ropert_nathan_tpjavafx;
    exports com.example.ropert_nathan_tpjavafx.Des;
    opens com.example.ropert_nathan_tpjavafx.Des to javafx.fxml;
    exports com.example.ropert_nathan_tpjavafx.Evenement;
    opens com.example.ropert_nathan_tpjavafx.Evenement to javafx.fxml;
}