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


public class FromToPage extends WizardPage implements KeyListener{
	
	private Label lblFrom;
	private Label lblTo;
	private Label lblVia;
	
	private Text tfFrom;
	private Text tfTo;
	private Text tfVia;
	
	private Composite pageContainer;
	 
	public FromToPage() {
		super("From To Page");
		setTitle("Enter the following details");
		setDescription("Source and Destination are mandatory");
	}
	
	@Override
	public void createControl(org.eclipse.swt.widgets.Composite parent) {
		pageContainer = new Composite(parent, SWT.NULL);
		GridLayout pageLayout = new GridLayout();
		pageContainer.setLayout(pageLayout);
		pageLayout.numColumns = 2;
		
		lblFrom = new Label(pageContainer, SWT.NONE);
		lblFrom.setText("From*  ");
		
		tfFrom = new Text(pageContainer, SWT.None|SWT.BORDER);
		tfFrom.setText("");
		tfFrom.addKeyListener(this);
		
		lblTo = new Label(pageContainer, SWT.NONE);
		lblTo.setText("To*  ");
		
		tfTo = new Text(pageContainer, SWT.None|SWT.BORDER);
		tfTo.setText("");
		tfTo.addKeyListener(this);
		
		lblVia = new Label(pageContainer, SWT.NONE);
		lblVia.setText("Via  ");
		
		tfVia = new Text(pageContainer, SWT.None|SWT.BORDER);
		tfVia.setText("");
		
				
		GridData grid = new GridData(GridData.FILL_HORIZONTAL);
		tfFrom.setLayoutData(grid);
		tfTo.setLayoutData(grid);
		tfVia.setLayoutData(grid);
		
		setControl(pageContainer);
		setPageComplete(false);
		
	} 
	
	
	public String getFrom(){
		return tfFrom.getText();
	}
	
	public String getTo(){
		return tfTo.getText();
	}
	
	public String getVia(){
		return tfVia.getText();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if((!tfFrom.getText().isEmpty()) && (!tfTo.getText().isEmpty())){
			setPageComplete(true);
		}
		else{
			setPageComplete(false);
		}
		
	}

}
