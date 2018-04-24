/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Danshil K Mungur
 */
public class FXMLDocumentController implements Initializable {

	@FXML private Label label;
	@FXML private AnchorPane panel;

	@FXML
	private void handleButtonAction(ActionEvent event) {
//		System.out.println(event.getSource());
		System.out.println(panel.getChildren());

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}
