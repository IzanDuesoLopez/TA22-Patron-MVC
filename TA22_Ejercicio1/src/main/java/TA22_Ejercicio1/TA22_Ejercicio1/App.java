package TA22_Ejercicio1.TA22_Ejercicio1;

import controllers.Controller;
import models.Model;
import views.View;

public class App 
{
    public static void main( String[] args )
    {   
    	// We create view and model, the controller gets the objects instances
    	View view = new View();
    	Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.startView();
    }
}
