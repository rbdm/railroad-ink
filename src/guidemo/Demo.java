package guidemo;

import comp1110.ass2.util.StageManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * User: u6613739
 * Date: 2019/5/3
 * Time: 19:37
 * Description:
 */
public class Demo extends Application
{
    Stage startStage = new Stage();
    Stage optionStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(ClassLoader.getSystemResource("resource/StartForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("StarForm");
        stage.show();
        StageManager.stageMap.put("StartFormStage",stage);

    }

    public static void main(String[] args)
    {
        launch(args);
    }
    private void newStage(String name,String uri, Stage stage) throws IOException
    {
        Parent root = FXMLLoader.load(ClassLoader.getSystemResource(uri));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(name);
        stage.show();
    }

}
