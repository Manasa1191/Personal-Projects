package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;  
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		ApplicationDetails app = new ApplicationDetails();
		app.showApplictaionDetails(primaryStage);
		//dbmsConnection dbmsconnect = new dbmsConnection("jdbc:mysql://localhost:3307/movieslist","root","");
		//Connection con =dbmsconnect.getConnection();
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		try {
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		launch(args);
		
	}

	
	class Movie{
		private String name;
		private String mov1;
		private String mov2;
		private String mov3;
		
		public Movie(String name, String mov1, String mov2, String mov3) {
			
			this.name = name;
			this.mov1 = mov1;
			this.mov2 = mov2;
			this.mov3 = mov3;
		}
		
		
		//this method sends details from JavaFX to database
		public void insertMovieDetails() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
			try {
			dbmsConnection dbmsconnect = new dbmsConnection("jdbc:mysql://localhost:3307/movieslist","root","");
			Connection con =dbmsconnect.getConnection();
			String sql = "insert into movies values (?,?,?,?);";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, mov1);
			stmt.setString(3, mov2);
			stmt.setString(4, mov3);
			int i=stmt.executeUpdate();
			if(i>0) {
				System.out.println("Record inserted successfully in databse");
			}
			else {
				System.out.println("Record not inserted in database");
			}
			stmt.close();
			con.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
		}
	}
	
	class dbmsConnection {
		String url;
		String username;
		String password;
		
		public dbmsConnection(String url, String username, String password) {
			
			this.url = url;
			this.username = username;
			this.password = password;
		}

		//establishing connection to mysql data base
		public Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Data base Connection succesful");
			/*Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from movies;");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			stmt.close();
			con.close();*/
			return con;
			
		}
	}

	class ApplicationDetails{
		Label lbl;
		TextField nameText;
		Label lblMovies;
		TextField movie1;
		TextField movie2;
		TextField movie3;
		Button button;
		Label lblOutput;
		//method that builds javaFX application and event handler for button
		public void showApplictaionDetails(Stage primaryStage) {
			//list of controls
			//create label for user name
			lbl = new Label("Enter User Name");
			lbl.setTextFill(Color.RED);
			lbl.setFont(new Font("Times New Roman", 14));
			//create a text field for name
			nameText = new TextField();
			nameText.setMaxWidth(150);
			//create a label for movies 
			lblMovies = new Label("Enter 3 Favourite Movies");
			//create 3 text fields for movies and store user input in 3 string variables
			movie1 = new TextField();
			movie1.setMaxWidth(100);
			movie2 = new TextField();
			movie2.setMaxWidth(100);
			movie3 = new TextField();
			movie3.setMaxWidth(100);
			//button control
			button = new Button("Add Movies");
			//this label is displayed when Add Movies button is clicked
			lblOutput = new Label();
			
			
			//layout
			VBox root = new VBox();
			//add all controls to the layout
			root.getChildren().addAll(lbl,nameText,lblMovies,movie1,movie2,movie3);
			root.setSpacing(20);
			root.getChildren().addAll(button,lblOutput);
			//add VBox layout to scene 
			Scene scene = new Scene(root,600,400);
			// add our scene to a stage
			primaryStage.setScene(scene);
			primaryStage.setTitle("Add Movies To Your Account");
			primaryStage.show();
			
			
			//Create an event handler when Add Movies button is clicked
			button.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				//this method is executed when user clicks on Add Movies button
				public void handle(ActionEvent arg0) {
					lblOutput.setText("Movies Added to Database");
					lblOutput.setTextFill(Color.RED);
					Movie movie = new Movie(nameText.getText(),movie1.getText(),movie2.getText(),movie3.getText());
					try {
						movie.insertMovieDetails();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			
			});
			
		}
	}
}
