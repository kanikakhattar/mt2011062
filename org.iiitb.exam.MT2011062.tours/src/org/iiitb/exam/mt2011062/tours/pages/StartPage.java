package org.iiitb.exam.mt2011062.tours.pages;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class StartPage extends WizardPage{
	
	private Label lblTourName;
	private Text tfTourName;
	private Composite pageContainer;
	 
	public StartPage() {
		super("Start Page");
		setTitle("Start with the planning");
		setDescription("Add the tour name");
	}
	
	@Override
	public void createControl(org.eclipse.swt.widgets.Composite parent) {
		pageContainer = new Composite(parent, SWT.NULL);
		GridLayout pageLayout = new GridLayout();
		pageContainer.setLayout(pageLayout);
		pageLayout.numColumns = 2;
		
		lblTourName = new Label(pageContainer, SWT.NONE);
		lblTourName.setText("Tour Name");
		
		tfTourName = new Text(pageContainer, SWT.None|SWT.BORDER);
		tfTourName.setText("");
		
		tfTourName.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(!tfTourName.getText().isEmpty()){
					setPageComplete(true);
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		GridData grid = new GridData(GridData.FILL_HORIZONTAL);
		tfTourName.setLayoutData(grid);
		
		setControl(pageContainer);
		setPageComplete(false);
		
		
	} 
	
	public String getTourName(){
		return tfTourName.getText();
	}

}
