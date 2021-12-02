package ventanaProductos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileOutputStream;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;



public class ControllerProductos{

    @FXML
    private TextField cajaIdProducto;


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
    public void generarCodigoRandom(ActionEvent event){
        int indice;
        String[] auxiliar = new String[8];
        String auxiliar2;
        for(int x=0;x<8;x++){
            indice=(int)(Math.random()*10);
            auxiliar[x]=String.valueOf(indice);
        }
        auxiliar2=auxiliar[0];
        for(int x=1;x<8;x++){
            auxiliar2=auxiliar2+auxiliar[x];
        }
        cajaIdProducto.setText(auxiliar2);
        // Guardar Codigo de barras como imagen
        Barcode barcode = null;
        String strCode = auxiliar2;
        try {
            barcode = BarcodeFactory.createCode39(strCode, true);//Reemplazar esto por el valor que deseen
        } catch (BarcodeException e) {
        }
        barcode.setDrawingText(true);//determina si se agrega o no el número codificado debajo del código de barras
        //tamaño de la barra
        barcode.setBarWidth(2);
        barcode.setBarHeight(60);

        try {
            //Ruta y nombre del archivo PNG a crear
            String strFileName= "C:\\Users\\PC\\Desktop\\codigos\\codigoDeBarras"+strCode+".PNG";
            File file = new File(strFileName);
            FileOutputStream fos = new FileOutputStream(file);
            BarcodeImageHandler.writePNG(barcode, fos);//formato de ejemplo PNG
            System.out.println("Archivo creado: "+strFileName);
        } catch (Exception ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
    }
}
