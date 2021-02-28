
import controller.ControladorAñadirTarea;
import controller.ControladorLogin;
import controller.GestorTareas;
import controller.Pantalla;
import controller.PersonController;
import controller.ScreenEnum;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Login;
import model.Person;
import model.Tarea;
import repositorio.BaseDatos;

public class App extends Application {

    @Override
    public void start(Stage stage) {
      

        try {
            stage.setTitle("App de Tareas");
            stage.setOnCloseRequest(windowEvent -> {
                exitApplication(windowEvent);
            });
            var navigation = wireScreens(stage);//creamoos un objeto de Tipo Pantalla y le pasamos el stage
            navigation.Navigate(ScreenEnum.AñadirTareas);//le metemos el login

       

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
            /*   var fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/vistaTarea.fxml"));
            
            var controladorTarea = new ControladorAñadirTarea(new Tarea());
            fxmlLoader.setController(controladorTarea);
            
            var root = (Pane)fxmlLoader.load();
             root.setId("pane");
             
            var scene = new Scene(root);
             scene.getStylesheets().addAll(this.getClass().getResource("styles/fondo.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
             */
            //Ver Tareas creadas
            /*var fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/gestorTareas.fxml"));
            
            GestorTareas gestorTareas = new GestorTareas(new BaseDatos());
            fxmlLoader.setController(gestorTareas);
            
            var root = (Pane)fxmlLoader.load();
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.show();*/
            //GestorTareas
            /*  
         var fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/gestorTareas.fxml"));
            
            var gestorTareas = new GestorTareas(new BaseDatos());
            fxmlLoader.setController(gestorTareas);
            
            var root = (Pane)fxmlLoader.load();
             root.setId("pane");
             
            var scene = new Scene(root);
             scene.getStylesheets().addAll(this.getClass().getResource("styles/fondo.css").toExternalForm());
            stage.setScene(scene);
            stage.show();*/
            
            
            /*
                 //Login desde aqui empezamos
            var fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/login.fxml"));

           // ControladorLogin controlLogin = new ControladorLogin(new Login());
         //   fxmlLoader.setController(controlLogin);

            var root = (Pane) fxmlLoader.load();
            root.setId("pane");
            var scene = new Scene(root);
            scene.getStylesheets().addAll(this.getClass().getResource("styles/fondo.css").toExternalForm());

            stage.setScene(scene);
            stage.show();
            */
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
  private BaseDatos baseDatos;
    /**
     * Funcion para navegar entre las diferentes ventanas de la aplicacion
     * @param stage stage del main
     * @return un objeto de tipo Pantalla
     * @throws IOException 
     */
    private Pantalla wireScreens(Stage stage) throws IOException {
        this.baseDatos = new BaseDatos();
        var navigation = new Pantalla(stage);//creamos el navegation de la stage

        var loginLoader = new FXMLLoader();
        loginLoader.setLocation(getClass().getResource("/view/login.fxml"));
        var login = new Login();
        var controladorLogin = new ControladorLogin(login, navigation);
        loginLoader.setController(controladorLogin);
        var loginRoot = (Pane)loginLoader.load();

        var loginScene = new Scene(loginRoot);
        loginScene.getStylesheets().add(getClass().getResource("styles/fondo.css").toExternalForm());

        
           var tareaLoader = new FXMLLoader();
        tareaLoader.setLocation(getClass().getResource("/view/vistaTarea.fxml"));
        var tarea = new Tarea();
        var controladorTarea = new ControladorAñadirTarea(tarea, navigation,this.baseDatos);
        tareaLoader.setController(controladorTarea);
        var tareaRoot = (Pane)tareaLoader.load();

        var tareaScene = new Scene(tareaRoot);
        tareaScene.getStylesheets().add(getClass().getResource("styles/fondo.css").toExternalForm());

        
        
        
          var gestorLoader = new FXMLLoader();
        gestorLoader.setLocation(getClass().getResource("/view/gestorTareas.fxml"));
       
        var controladorGestorTareas = new GestorTareas(this.baseDatos, navigation);
        gestorLoader.setController(controladorGestorTareas);
        var gestorRoot = (Pane)gestorLoader.load();

        var gestorScene = new Scene(gestorRoot);
        gestorScene.getStylesheets().add(getClass().getResource("styles/fondo.css").toExternalForm());
        
        navigation.Add(ScreenEnum.AñadirTareas, tareaScene);
        navigation.Add(ScreenEnum.Login, loginScene);
        
        navigation.Add(ScreenEnum.GestorTareas, gestorScene);
        
        
        
        
                return navigation;

        
    }

    public static void main(String[] args) {
        launch();
    }

    private void exitApplication(Event e) {
        var alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de que deseas salir?");
        var result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Platform.exit();
        } else {
            e.consume();
        }
    }

}
