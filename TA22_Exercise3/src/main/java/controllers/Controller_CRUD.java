package controllers;

import javax.swing.JFrame;

import models.Model_DB;
import views.View_tables;

public class Controller_CRUD {

	private Model_DB model;
	private View_tables view;
	
	public Controller_CRUD(Model_DB model, View_tables view) {
		this.model = model;
		this.view = view;
	}
	
	public void startView() {
		view.setTitle("C4_UD22_02");
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
	}
}
