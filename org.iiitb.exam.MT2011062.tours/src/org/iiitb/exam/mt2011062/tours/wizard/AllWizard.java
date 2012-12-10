package org.iiitb.exam.mt2011062.tours.wizard;

import java.sql.Connection;
import java.sql.DriverManager;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.iiitb.exam.mt2011062.tours.*;
import org.iiitb.exam.mt2011062.tours.database.ConnectMySql;
import org.iiitb.exam.mt2011062.tours.pages.*;


public class AllWizard extends Wizard implements INewWizard{

	protected StartPage startPage;
	protected FromToPage fromToPage;
	protected AgentPage agentPage;
	
	public AllWizard(){
		setNeedsProgressMonitor(true);
	}
	
	public void addPages(){
		startPage = new StartPage();
		fromToPage = new FromToPage();
		agentPage = new AgentPage();
		
		addPage(startPage);
		addPage(fromToPage);
		addPage(agentPage);
				
	}
	
	@Override
	public boolean performFinish() {
		System.out.println(startPage.getTourName());
		System.out.println(fromToPage.getFrom());
		System.out.println(fromToPage.getTo());
		System.out.println(fromToPage.getVia());
		System.out.println(agentPage.getAgentName());
		System.out.println(agentPage.getTourDate());
		
		String query;
		
		int v;
        try{
           
        	query = "insert into Travels (Tour_Name, FromPlace, ToPlace, Via, Agent_Name, Tour_Date) values ('"+ startPage.getTourName() +"','"+ fromToPage.getFrom() +"','"+ fromToPage.getTo() +"','"+ fromToPage.getVia() +"','"+ agentPage.getAgentName() +"','"+ agentPage.getTourDate() +"');";
    		System.out.println("Query to exe: "+query);
            v = ConnectMySql.update(query);
        }
        catch(Exception e){
           
            e.printStackTrace();
           
        }
		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		
	}

}
