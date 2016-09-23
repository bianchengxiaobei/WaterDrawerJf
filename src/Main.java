import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import com.waterdrawer.clientmain.ClientMain;
import com.waterdrawer.ui.UIManager;


public class Main extends Application
{
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
    @Override 
    public void init() throws Exception 
    {
        ClientMain.getInstance().start();
    }
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("WaterDrawer");
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(UIManager.Root);
		borderPane.setCenter(UIManager.splitPane);
		borderPane.getChildren().add(UIManager.copyButton);
		Scene scene = new Scene(borderPane,800,600);		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}