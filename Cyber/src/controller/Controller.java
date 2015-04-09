package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Fielddb;
import view.AddColumn;
import view.Login;
import view.addTable;

public class Controller {
	
	Fielddb tablename;
	addTable colum;
	
	public Controller(Fielddb tablename,addTable colum){
		
		this.tablename=tablename;
		this.colum=colum;
	//	colum.ColumnMap(new ColumnMap());
		
		
	}
	
	public class ColumnMap implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}
		
	}
		
	
		
			}

