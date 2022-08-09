package TA22.TA22;

import controllers.Controller_CRUD;
import models.Model_DB;
import views.View_tables;

public class App 
{
    public static void main( String[] args )
    {
    	View_tables view = new View_tables();
    	Model_DB model = new Model_DB();
    	Controller_CRUD controller = new Controller_CRUD(model, view);
    	controller.startView();
    }
}
