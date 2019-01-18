import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginWin extends Application {
	Scene scene;
	static UserCollector uc;

	public LoginWin() {
		uc = new UserCollector();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
// Load from file
		uc.Load();
//Create window		
		primaryStage.setTitle("Login");
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(10);
		gridPane.setHgap(10);
// Create controls	
		TextField name_t = new TextField("Name");
		TextField type_t = new TextField("Type");
		TextField pass_t = new TextField("Password");

		Button add = new Button("Add");
		add.setOnAction(e -> {
			User user = new User(name_t.getText(), type_t.getText(), pass_t.getText(), (int) Math.random() * 10);
			uc.Insert(user);
		});

		Button save = new Button("Save");
		save.setOnAction(e -> uc.Save());

		Button load = new Button("Load");
		load.setOnAction(e -> uc.Load());
		load.setDisable(true);
		
// Composite
		
		GridPane.setConstraints(name_t, 0, 0);
		GridPane.setConstraints(type_t, 0, 1);
		GridPane.setConstraints(pass_t, 0, 2);
		GridPane.setConstraints(add, 0, 3);
		GridPane.setConstraints(save, 0, 4);
		GridPane.setConstraints(load, 0, 5);

		gridPane.getChildren().addAll(name_t,type_t,pass_t, add, save, load);
		scene = new Scene(gridPane, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
