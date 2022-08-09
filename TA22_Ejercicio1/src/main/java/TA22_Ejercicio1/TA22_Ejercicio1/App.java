package TA22_Ejercicio1.TA22_Ejercicio1;

import controllers.Controller;
import models.Model;
import views.View;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {    
    	Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.startView();
    }
}
