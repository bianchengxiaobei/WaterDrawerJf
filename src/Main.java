import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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
    };
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("WaterDrawer");
		Group g = new Group();
		Scene scene = new Scene(g,800,600);
		g.getChildren().add(UIManager.root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}