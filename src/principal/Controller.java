package principal;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Controller {
    @FXML private ImageView btnProductos;
    @FXML private ImageView btnVentas;
    @FXML private ImageView btnInventario;
    @FXML private ImageView btnSalir;
    @FXML private AnchorPane paneMaestro;

    @FXML
    public void ventanaProductos(MouseEvent event){
        try{
            Parent window3;
            window3 = (AnchorPane)FXMLLoader.load(getClass().getResource("../ventanaProductos/vistaProductos.fxml"));

            Scene newScene;
            newScene = new Scene(window3);
            newScene.setFill(Color.TRANSPARENT);
            Stage mainWindow;

            mainWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
            mainWindow.toFront();
            mainWindow.show();
            mainWindow.setScene(newScene);
            btnProductos.setVisible(true);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ventanaVentas(MouseEvent event){
        try{
            Parent window4;
            window4 = (AnchorPane)FXMLLoader.load(getClass().getResource("../ventanaVentas/vistaVentas.fxml"));

            Scene newScene1;
            newScene1 = new Scene(window4);
            newScene1.setFill(Color.TRANSPARENT);
            Stage mainWindow1;

            mainWindow1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            mainWindow1.toFront();
            mainWindow1.show();
            mainWindow1.setScene(newScene1);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ventanaReportes(MouseEvent event){
        try{
            Parent window5;
            window5 = (AnchorPane)FXMLLoader.load(getClass().getResource("../ventanaReportes/vistaReportes.fxml"));

            Scene newScene2;
            newScene2 = new Scene(window5);
            newScene2.setFill(Color.TRANSPARENT);
            Stage mainWindow2;

            mainWindow2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            mainWindow2.toFront();
            mainWindow2.show();
            mainWindow2.setScene(newScene2);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void salir(MouseEvent event){
        Platform.exit();
        System.exit(0);
    }
}
