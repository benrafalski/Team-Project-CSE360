import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javafx.scene.text.Font;

public class OptionsPanel extends JPanel implements ActionListener {
	
	//buttons
	JButton aboutButton;
	JButton loadButton;
	JButton addButton;
	JButton saveButton;
	JButton viewButton;
	JButton showButton;
	JButton addInfoButton;
	JButton loadFileButton;
	JButton saveFileButton;
	
	//labels
	JLabel teamMembersLabel;
	JLabel optionsLabel;
	JLabel addLabel;
	JLabel loadedLabel;
	JLabel loadinstLabel;
	JLabel loadErrorLabel;
	JLabel infoAddedLabel;
	JLabel saveinstLabel;
	JLabel savedLabel;
	
	//table
	JTable table;
	JScrollPane pane;
	Object[] rows;
	DefaultTableModel model;
	
	//text fields
	JTextField addDate;
	JTextField addID;
	JTextField addLast;
	JTextField addFirst;
	JTextField addType;
	JTextField addLocation;
	
	//ArrayList
	ArrayList<Vaccine> vaccines = new ArrayList<Vaccine>();
	
	
	
	OptionsPanel(){
		
		//options label
		optionsLabel  = new JLabel();
		optionsLabel.setText("Options");
		optionsLabel.setForeground(Color.WHITE);
		optionsLabel.setBounds(29, 0, 50, 50);
		//team members and number label
		teamMembersLabel  = new JLabel();
		teamMembersLabel.setText("<html>Team Number 34:<br/>Ethan Hakim<br/>Abraham Martinez<br/>Jordan Post<br/>Benjamin Rafalski<html>");
		teamMembersLabel.setFont(teamMembersLabel.getFont().deriveFont(30.0f));
		teamMembersLabel.setForeground(Color.WHITE);
		teamMembersLabel.setBounds(250, 50, 300, 300);
		//about button
		aboutButton = new JButton();
		aboutButton.setBounds(10, 40, 80, 50);
		aboutButton.addActionListener(this);
		aboutButton.setText("About");
		aboutButton.setFocusable(false);
		//load button
		loadButton = new JButton();
		loadButton.setBounds(10, 100, 80, 50);
		loadButton.addActionListener(this);
		loadButton.setText("Load");
		loadButton.setFocusable(false);
		//add button
		addButton = new JButton();
		addButton.setBounds(10, 160, 80, 50);
		addButton.addActionListener(this);
		addButton.setText("Add");
		addButton.setFocusable(false);
		//save button
		saveButton = new JButton();
		saveButton.setBounds(10, 220, 80, 50);
		saveButton.addActionListener(this);
		saveButton.setText("Save");
		saveButton.setFocusable(false);
		//view button
		viewButton = new JButton();
		viewButton.setBounds(10, 280, 80, 50);
		viewButton.addActionListener(this);
		viewButton.setText("View");
		viewButton.setFocusable(false);
		//show table button
		showButton = new JButton();
		showButton.setBounds(10, 340, 80, 50);
		showButton.addActionListener(this);
		showButton.setText("<html>Show<br/>Table<html>");
		showButton.setFocusable(false);
		
		//table stuff
		table = new JTable();
		Object[] columns = {"ID", "Last Name", "First Name", "Vaccine Type", "Vaccination Date", "Location"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLUE);
		table.setSelectionBackground(Color.red);
		table.setGridColor(Color.red);
		table.setSelectionForeground(Color.WHITE);
		table.setAutoCreateRowSorter(true);
		//table panel
		pane = new JScrollPane(table);
		pane.setBounds(100, 30, 590, 340);
		pane.setForeground(Color.red);
		pane.setBackground(Color.WHITE);
		//table rows
		rows = new Object[6];
		
		//add stuff
		addLabel  = new JLabel();
		addLabel.setText("<html>Date:<br/>ID:<br/>Last Name:<br/>First Name:<br/>Vaccination Type:<br/>Location:<html>");
		addLabel.setFont(teamMembersLabel.getFont().deriveFont(30.0f));
		addLabel.setForeground(Color.WHITE);
		addLabel.setBounds(150, 50, 300, 300);
		infoAddedLabel  = new JLabel();
		infoAddedLabel.setText("");
		infoAddedLabel.setForeground(Color.RED);
		infoAddedLabel.setBounds(290, 350, 200, 50);
		//text fields for add function
		addDate = new JTextField();
		addDate.setBounds(250, 90, 200, 30);
		addID = new JTextField();
		addID.setBounds(215, 130, 200, 30);
		addLast = new JTextField();
		addLast.setBounds(337, 170, 200, 30);
		addFirst = new JTextField();
		addFirst.setBounds(340, 210, 200, 30);
		addType = new JTextField();
		addType.setBounds(430, 247, 200, 30);
		addLocation = new JTextField();
		addLocation.setBounds(310, 285, 200, 30);
		//add button for add function
		addInfoButton = new JButton();
		addInfoButton.setBounds(330, 330, 80, 30);
		addInfoButton.addActionListener(this);
		addInfoButton.setText("Add Info");
		addInfoButton.setFocusable(false);
		
		//load stuff
		loadFileButton = new JButton();
		loadFileButton.setBounds(330, 330, 150, 30);
		loadFileButton.addActionListener(this);
		loadFileButton.setText("Select A File");
		loadFileButton.setFocusable(false);
		//load instructions label
		loadinstLabel  = new JLabel();
		loadinstLabel.setText("Please select a .csv file to be loaded");
		loadinstLabel.setForeground(Color.WHITE);
		loadinstLabel.setBounds(305, 150, 400, 50);
		//loaded label
		loadedLabel  = new JLabel();
		loadedLabel.setText("File Loaded!");
		loadedLabel.setForeground(Color.RED);
		loadedLabel.setBounds(372, 290, 100, 50);
		//loaded error label
		loadErrorLabel  = new JLabel();
		loadErrorLabel.setText("File Was Not Loaded!");
		loadErrorLabel.setForeground(Color.RED);
		loadErrorLabel.setBounds(372, 290, 100, 50);
		
		//save stuff
		saveFileButton = new JButton();
		saveFileButton.setBounds(330, 330, 150, 30);
		saveFileButton.addActionListener(this);
		saveFileButton.setText("Select A File");
		saveFileButton.setFocusable(false);
		//save instructions label
		saveinstLabel  = new JLabel();
		saveinstLabel.setText("Please select a .csv file to be saved");
		saveinstLabel.setForeground(Color.WHITE);
		saveinstLabel.setBounds(305, 150, 400, 50);
		//saved label
		savedLabel  = new JLabel();
		savedLabel.setText("");
		savedLabel.setForeground(Color.RED);
		savedLabel.setBounds(310, 290, 400, 50);
		
		//main panel settings
		this.setBackground(new Color(123,50,250));
		this.setBounds(25, 100, 700, 400);
		this.setLayout(null);
		this.add(aboutButton);
		this.add(loadButton);
		this.add(addButton);
		this.add(saveButton);
		this.add(viewButton);
		this.add(showButton);
		this.add(optionsLabel);
		this.add(pane);
		this.repaint();
		
	}
	
	// does something on the action of a button push
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == aboutButton) {
			//displays teamMembersLabel information
			this.remove(addLabel);
			this.remove(pane);
			this.remove(addLabel);
			this.remove(addDate);
			this.remove(addID);
			this.remove(addLast);
			this.remove(addFirst);
			this.remove(addType);
			this.remove(addLocation);
			this.remove(addInfoButton);
			this.remove(loadFileButton);
			this.remove(loadedLabel);
			this.remove(loadinstLabel);
			this.remove(loadErrorLabel);
			this.remove(infoAddedLabel);
			this.remove(saveFileButton);
			this.remove(saveinstLabel);
			this.remove(savedLabel);
			this.add(teamMembersLabel);
			this.repaint();
		}else if(e.getSource() == loadButton) {
			this.remove(addLabel);
			this.remove(pane);
			this.remove(teamMembersLabel);
			this.remove(addLabel);
			this.remove(addDate);
			this.remove(addID);
			this.remove(addLast);
			this.remove(addFirst);
			this.remove(addType);
			this.remove(addLocation);
			this.remove(addInfoButton);
			this.remove(loadedLabel);
			this.remove(loadErrorLabel);
			this.remove(infoAddedLabel);
			this.remove(saveinstLabel);
			this.remove(saveFileButton);
			this.remove(savedLabel);
			this.add(loadFileButton);
			this.add(loadinstLabel);
			this.repaint();
		}else if(e.getSource() == addButton) {
			//displays area for user to enter and add information
			this.remove(teamMembersLabel);
			this.remove(pane);
			this.remove(loadFileButton);
			this.remove(loadedLabel);
			this.remove(loadinstLabel);
			this.remove(infoAddedLabel);
			this.remove(loadErrorLabel);
			this.remove(saveFileButton);
			this.remove(saveinstLabel);
			this.remove(savedLabel);
			this.add(addLabel);
			this.add(addDate);
			this.add(addID);
			this.add(addLast);
			this.add(addFirst);
			this.add(addType);
			this.add(addLocation);
			this.add(addInfoButton);
			this.repaint();
		}else if(e.getSource() == saveButton) {
			this.remove(addLabel);
			this.remove(pane);
			this.remove(teamMembersLabel);
			this.remove(addLabel);
			this.remove(addDate);
			this.remove(addID);
			this.remove(addLast);
			this.remove(addFirst);
			this.remove(addType);
			this.remove(addLocation);
			this.remove(addInfoButton);
			this.remove(loadFileButton);
			this.remove(loadedLabel);
			this.remove(loadinstLabel);
			this.remove(loadErrorLabel);
			this.remove(infoAddedLabel);
			this.add(saveFileButton);
			this.add(saveinstLabel);
			this.add(savedLabel);
			savedLabel.setText("");
			this.repaint();
		}else if(e.getSource() == viewButton) {
			this.remove(addLabel);
			this.remove(pane);
			this.remove(teamMembersLabel);
			this.remove(addLabel);
			this.remove(addDate);
			this.remove(addID);
			this.remove(addLast);
			this.remove(addFirst);
			this.remove(addType);
			this.remove(loadFileButton);
			this.remove(addLocation);
			this.remove(addInfoButton);
			this.remove(loadedLabel);
			this.remove(loadinstLabel);
			this.remove(loadErrorLabel);
			this.remove(infoAddedLabel);
			this.remove(saveFileButton);
			this.remove(saveinstLabel);
			this.remove(savedLabel);
			this.repaint();
		}else if(e.getSource() == addInfoButton) {
			//adds new info to table
			this.add(infoAddedLabel);
			if(addID.getText().compareTo("") == 0) {
				addID.setText("");
				addLast.setText("");
				addFirst.setText("");
				addType.setText("");
				addDate.setText("");
				addLocation.setText("");
				infoAddedLabel.setText("Information Not Added to Table!");
				this.repaint();
			}else if(addLast.getText().compareTo("") == 0) {
				addID.setText("");
				addLast.setText("");
				addFirst.setText("");
				addType.setText("");
				addDate.setText("");
				addLocation.setText("");
				infoAddedLabel.setText("Information Not Added to Table!");
				this.repaint();
			}else if(addFirst.getText().compareTo("") == 0) {
				addID.setText("");
				addLast.setText("");
				addFirst.setText("");
				addType.setText("");
				addDate.setText("");
				addLocation.setText("");
				infoAddedLabel.setText("Information Not Added to Table!");
				this.repaint();
			}else if(addType.getText().compareTo("") == 0) {
				addID.setText("");
				addLast.setText("");
				addFirst.setText("");
				addType.setText("");
				addDate.setText("");
				addLocation.setText("");
				infoAddedLabel.setText("Information Not Added to Table!");
				this.repaint();
			}else if(addDate.getText().compareTo("") == 0) {
				addID.setText("");
				addLast.setText("");
				addFirst.setText("");
				addType.setText("");
				addDate.setText("");
				addLocation.setText("");
				infoAddedLabel.setText("Information Not Added to Table!");
				this.repaint();
			}else if(addLocation.getText().compareTo("") == 0) {
				addID.setText("");
				addLast.setText("");
				addFirst.setText("");
				addType.setText("");
				addDate.setText("");
				addLocation.setText("");
				infoAddedLabel.setText("Information Not Added to Table!");
				this.repaint();
			}else {
				rows[0] = addID.getText();
				rows[1] = addLast.getText();
				rows[2] = addFirst.getText();
				rows[3] = addType.getText();
				rows[4] = addDate.getText();
				rows[5] = addLocation.getText();
				Vaccine addedVaccine = new Vaccine(addID.getText(),addLast.getText(),addFirst.getText(),addType.getText(),addDate.getText(),addLocation.getText());
				vaccines.add(addedVaccine);
				model.addRow(rows);
				addID.setText("");
				addLast.setText("");
				addFirst.setText("");
				addType.setText("");
				addDate.setText("");
				addLocation.setText("");
				infoAddedLabel.setText("Information Added to Table!");
				this.repaint();
			}
		}else if(e.getSource() == loadFileButton) {
			this.remove(loadedLabel);
			this.remove(loadErrorLabel);
			JFileChooser fileChooser = new JFileChooser();
			int response = fileChooser.showOpenDialog(null); // select file to load
			//int response = fileChooser.showSaveDialog(null); // select file to save
			if(response == JFileChooser.APPROVE_OPTION) {
				// gets file path 
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				if(file.exists()) {
					this.add(loadedLabel);
					this.repaint();
					String line = "";
					int i = 0;
					model.setRowCount(0);
					try {
						//adds data to the table
						BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile().getAbsolutePath()));
						while((line = br.readLine()) != null) {
							if(i == 1) {
								String[] values = line.split(",");
								rows[0] = values[0];
								rows[1] = values[1];
								rows[2] = values[2];
								rows[3] = values[3];
								rows[4] = values[4];
								rows[5] = values[5];
								Vaccine loadedVaccine = new Vaccine(values[0],values[1],values[2],values[3],values[4],values[5]);
								vaccines.add(loadedVaccine);
								model.addRow(rows);
							}else {
								i = 1;
							}
						}
					}catch(FileNotFoundException e2) {
						e2.printStackTrace();
					} catch (IOException e3) {
						e3.printStackTrace();
					}
				}else {
					this.add(loadErrorLabel);
				}
			}
		}else if(e.getSource() == saveFileButton) {
			savedLabel.setText("");
			this.repaint();
			JFileChooser fileSaver = new JFileChooser();
			int response = fileSaver.showSaveDialog(null); // select file to save
			if(response == JFileChooser.APPROVE_OPTION) {
				// gets file path
				savedLabel.setText("Information Saved to Selected File!");
				this.repaint();
				File save = new File(fileSaver.getSelectedFile().getAbsolutePath());
				if(save.exists()) {
					try {
						//overwrites file
						PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileSaver.getSelectedFile().getAbsolutePath(), false)));
						pw.println("ID,Last Name,First Name,Vaccine Type,Vaccination Date,Vaccine Location");
						for(int i = 0; i < vaccines.size(); i++) {
							pw.println(vaccines.get(i).getID()+","+vaccines.get(i).getLast()+","+vaccines.get(i).getFirst()+","+vaccines.get(i).getType()+","+vaccines.get(i).getDate()+","+vaccines.get(i).getLocation());
						}
						pw.flush();
						pw.close();
					}catch(Exception e4) {
						e4.printStackTrace();
					}
				}else {
					savedLabel.setText("Information Not Saved to Selected File!");
					this.repaint();
				}
			}
		}else {
			//show table
			this.remove(addLabel);
			this.remove(loadedLabel);
			this.remove(pane);
			this.remove(addLabel);
			this.remove(teamMembersLabel);
			this.remove(addLabel);
			this.remove(addDate);
			this.remove(addID);
			this.remove(addLast);
			this.remove(addFirst);
			this.remove(addType);
			this.remove(addLocation);
			this.remove(addInfoButton);
			this.remove(loadFileButton);
			this.remove(loadinstLabel);
			this.remove(loadErrorLabel);
			this.remove(infoAddedLabel);
			this.remove(saveFileButton);
			this.remove(saveinstLabel);
			this.remove(savedLabel);
			this.add(pane);
			this.repaint();
		}
		
		
	}
}
