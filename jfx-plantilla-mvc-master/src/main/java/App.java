import controller.ControladorAñadirTarea;
import controller.ControladorLogin;
import controller.PersonController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Login;
import model.Person;
import model.Tarea;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try{
          /*  base
            var fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/viewaddtask.fxml"));
            
            var personController = new PersonController(new Person());
            fxmlLoader.setController(personController);
            
            var root = (Pane)fxmlLoader.load();
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.show();*/
          
           
          //Añadir tareas
          var fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/vistaTarea.fxml"));
            
            var controladorTarea = new ControladorAñadirTarea(new Tarea());
            fxmlLoader.setController(controladorTarea);
            
            var root = (Pane)fxmlLoader.load();
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
           
           
           //Login desde aqui empezamos
         /**  var fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/login.fxml"));
            
            ControladorLogin controlLogin = new ControladorLogin(new Login());
            fxmlLoader.setController(controlLogin);
            
            var root = (Pane)fxmlLoader.load();
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.show();*/
          
        }
        catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}