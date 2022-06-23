package nl.hhs.rentathing;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OverzichtController implements Initializable {
    User u;
    @javafx.fxml.FXML
    private ListView<Product> listView;
    @javafx.fxml.FXML
    private Label nameLabel;

    public void setUser(User u){
        this.u = u;
        nameLabel.setText(this.u.email);

    }

    @javafx.fxml.FXML
    public void beheerButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logoutButton(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @javafx.fxml.FXML
    public void homeButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-view.fxml"));
        Parent root = fxmlLoader.load();
        UserController userController = fxmlLoader.getController();
        userController.setUser(u);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Product> producten = null;
        try {
            producten = IDatabase.getDb(new Product(), "productendb");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        listView.getItems().addAll(producten);
    }
}
