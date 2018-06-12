package tests;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressIndicatorTest extends Application {

  public static void main(String[] args) {
     Application.launch(args);
  }

  @Override
  public void start(Stage stage) {
      stage.setTitle("Javafxtuts.com");
	// creating label
      Label lb=new Label(" Simple Progress Indicator ");
      ProgressIndicator spi = new ProgressIndicator();
	//creating label
      Label lb1=new Label(" another Progress Indicator ");
      ProgressIndicator pi = new ProgressIndicator();
      pi.setProgress(0.40F);
	 Separator separator =new Separator();
      VBox root =new VBox();
      root.setPadding(new Insets(20, 10, 10, 10));
      root.getChildren().addAll(spi,lb,separator,pi,lb1);
        Scene scene = new Scene(root, 250, 200);
        stage.setScene(scene);
        stage.show();
  }
}