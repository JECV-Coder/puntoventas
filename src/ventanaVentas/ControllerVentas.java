package ventanaVentas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Scanner;

public class ControllerVentas {
    String codigoId;
    @FXML
    TextField cajaBuscarProducto;
    @FXML
    public void botonMenu(MouseEvent event){
        try{

            Parent window3;
            window3 = (AnchorPane) FXMLLoader.load(getClass().getResource("../principal/sample.fxml"));

            Scene newScene;
            newScene = new Scene(window3);
            newScene.setFill(Color.TRANSPARENT);
            Stage mainWindow;

            mainWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
            mainWindow.toFront();
            mainWindow.show();
            mainWindow.setScene(newScene);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void VerDetalles(KeyEvent event){
        codigoId=cajaBuscarProducto.getText();
        if(codigoId.length()==8){
            System.out.println(codigoId);
        }
    }

}
