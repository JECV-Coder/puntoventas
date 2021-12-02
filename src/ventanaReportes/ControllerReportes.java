package ventanaReportes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.time.LocalDate;

public class ControllerReportes {
    @FXML
    private Button buscar;
    @FXML
    private TextField fechaBuscar;
    @FXML
    private TableView<Producto> table;

    @FXML private TableColumn<Producto,String> fechaCol;
    @FXML private TableColumn<Producto,String> idCol;
    @FXML private TableColumn<Producto,String> nombreCol;
    @FXML private TableColumn<Producto,String> cantidadCol;
    @FXML private TableColumn<Producto,String> subtotalCol;


    private final ObservableList<Producto> data = FXCollections.observableArrayList(
            new Producto("2010-04-02",12345678, "Coca Cola", 10, 15)
    );

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
    public void cargarArchivos(MouseEvent event){
        table.getItems().setAll(data);
    }

    @FXML
    public void buscarFecha(MouseEvent event){
        int x;
        String auxiliar = fechaBuscar.getText();
        String[] diaMesAnio = auxiliar.split(",");
        LocalDate date = LocalDate.of(Integer.parseInt(diaMesAnio[0]),Integer.parseInt(diaMesAnio[1]),Integer.parseInt(diaMesAnio[2]));
        System.out.println(date);
    }

    @FXML
    public void generarPDF(MouseEvent event){
        try
        {
            Document document = new Document();

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./AddTableExample.pdf"));
            document.open();

            PdfPTable table = new PdfPTable(5); // 3 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(5f); //Space before table
            table.setSpacingAfter(5f); //Space after table

            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("FECHA"));
            cell1.setBorderColor(BaseColor.BLACK);
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell2 = new PdfPCell(new Paragraph("ID"));
            cell2.setBorderColor(BaseColor.BLACK);
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell3 = new PdfPCell(new Paragraph("NOMBRE"));
            cell3.setBorderColor(BaseColor.BLACK);
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell4 = new PdfPCell(new Paragraph("CANTIDAD VENDIDA"));
            cell4.setBorderColor(BaseColor.DARK_GRAY);
            cell4.setPaddingLeft(10);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell5 = new PdfPCell(new Paragraph("SUBTOTAL"));
            cell5.setBorderColor(BaseColor.DARK_GRAY);
            cell5.setPaddingLeft(10);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);


            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);

            document.add(table);

            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
