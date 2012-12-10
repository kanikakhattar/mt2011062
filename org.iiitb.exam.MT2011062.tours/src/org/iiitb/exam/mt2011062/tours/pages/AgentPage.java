package org.iiitb.exam.mt2011062.tours.pages;
import java.util.Calendar;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class AgentPage extends WizardPage{
	
	private Label lblAgentName;
	private Label lblTourDate;
	
	private Combo cbAgents;
	private Composite pageContainer;
	DateTime tourDate;
	
	final static String[] agentNames = {"Yatra", "MakeMyTrip", "Clear Trip", "GoIbibo"};
	
	
	 
	public AgentPage() {
		super("Select Agent");
		setTitle("Provide the details");
		setDescription("");
	}
	
	@Override
	public void createControl(org.eclipse.swt.widgets.Composite parent) {
		pageContainer = new Composite(parent, SWT.NULL);
		GridLayout pageLayout = new GridLayout();
		pageContainer.setLayout(pageLayout);
		pageLayout.numColumns = 2;
		
		lblAgentName = new Label(pageContainer, SWT.NONE);
		lblAgentName.setText("Travel Agent ");
		
		cbAgents = new Combo(pageContainer, SWT.BORDER|SWT.READ_ONLY);
		cbAgents.setItems(agentNames);
		
		lblTourDate = new Label(pageContainer, SWT.NONE);
		lblTourDate.setText("Tour Date ");
		
		tourDate = new DateTime(pageContainer, SWT.CALENDAR);
		
		GridData grid = new GridData(GridData.FILL_HORIZONTAL);
		cbAgents.setLayoutData(grid);
		
		setControl(pageContainer);
		setPageComplete(true);
		
	} 
	
	public String getAgentName(){
		return cbAgents.getText();
	}
	
	public String getTourDate(){
		return tourDate.getYear() + "-" + (tourDate.getMonth()+1) + "-" + tourDate.getDay();
	}

}
