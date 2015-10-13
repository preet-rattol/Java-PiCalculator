package application;

import java.math.BigDecimal;	// importing the BigDecimal class


// imports from the javafx library
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private TextArea textArea;		// field for accessing the TextArea named textArea
	private TextField iteration;	// field for accessing the TextField named iterations
	private TextField precision;	// field for accessing the TextField named precision
	
	@Override						
	public void start(Stage primaryStage) {  //method that overrides the start method  
		try {                               // try and  catch for the method 
																																
			//AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
			AnchorPane root = fxmlLoader.load();

			Button calculate = (Button)fxmlLoader.getNamespace().get("calculate");   // calculate button
			Button clear = (Button)fxmlLoader.getNamespace().get("clear");			// clear button
			textArea = (TextArea)fxmlLoader.getNamespace().get("textArea");			// textArea 
			iteration = (TextField)fxmlLoader.getNamespace().get("iteration");		// iteration text-field
			precision = (TextField)fxmlLoader.getNamespace().get("precision");		// precision  text-field

			calculate.setOnAction(new EventHandler<ActionEvent>() {				// event handler for calculate button
				public void handle(ActionEvent e) {
					onStart(textArea);
				}
			});
			clear.setOnAction(new EventHandler<ActionEvent>() {					//event handler for clear button
				public void handle(ActionEvent e) {
					onClearClick();
				}
			});

			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	private void onStart(TextArea text){					// method for calculate button
		Calculator obj = new Calculator();					// object of Calculator class 
		
		try{												// try catch for wrong input 
		String itr = iteration.getText();					// String variable for getting  the value from iteration textfield
		int iterate = Integer.parseInt(itr);				// Converting string into an integer 

		String prec = precision.getText();					// String variable for getting value from precision textfield
		int precise = Integer.parseInt(prec);				// Converting string into an integer
		
		BigDecimal a = obj.calculatePi(iterate, precise);	// calling the calculatePi method from calculator class and passing the parameters.
		String str = a.toString();							// converting the return value of calculatePi mathod into String
		text.setText(str);									// displaying the result in the text area.
		}
		
		catch(NumberFormatException e){						
			textArea.setText("Wrong input ! Enter a valid Integer Value"); // message displayed for a wrong input
			
		}
	}

	public void onClearClick(){							// method for clear button
		 iteration.setText("");
		 precision.setText("");
		 textArea.setText("");
	

	}
}
