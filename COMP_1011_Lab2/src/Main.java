import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Revision Block
// Date--------------------By-----------------------Reason----------------
// 9/29/2020        Steven Davies               First Version

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    // Create the main start method
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gameView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        //primaryStage.setTitle("Version .01 Pre Alpha :)");
        primaryStage.show();
    }

}
