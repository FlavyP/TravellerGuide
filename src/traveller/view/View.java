package traveller.view;

import java.awt.event.ActionListener;

public interface View {
	public void createComponents();

	public void initializeComponents();

	public void addComponentsToFrame();

	public void addActionListeners(ActionListener actionListener);
	
	public String[] getInput();
	
	public void update(String[] update);
}
