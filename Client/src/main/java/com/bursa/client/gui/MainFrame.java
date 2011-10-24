package com.bursa.client.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -5284406119994569295L;

	public static final int frame_width = 700;
    public static final int frame_height = 500;
	
    public JTextArea status = null;
    
    
	public MainFrame() {
		this.configureFrame();
		this.addComponents();
	}

	private void configureFrame() {
		this.setSize(frame_width, frame_height);
        this.setTitle("Stock exchange client");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addComponents() {
		JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // menu bar
        panel.add(this.menuBar(), BorderLayout.NORTH);
        
        // center panel
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        center.add(this.status(), BorderLayout.NORTH);

        // center center panel
        JPanel center2 = new JPanel();
        center2.setLayout(new FlowLayout(FlowLayout.LEFT));
        center2.add(new JLabel("Display:"));
        center2.add(this.dropDown());
        
        center.add(center2, BorderLayout.CENTER);
        
        //center.add(this.dataTable(),BorderLayout.SOUTH);
        
        panel.add(center, BorderLayout.CENTER);
        
        this.add(panel);
	}

	/**
	 * @return a menu bar
	 */
	private Component menuBar() {
		JMenuBar menuBar = new JMenuBar();
        
		// New menu
		JMenu new_menu = new JMenu("New");
		JMenuItem conn = new JMenuItem("Connection");

		conn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		new_menu.add(conn);
		menuBar.add(new_menu);
		
		// Help Menu
		JMenu help_menu = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		
		about.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		help_menu.add(about);
		menuBar.add(help_menu);
		
		return menuBar;
	}


	private JTextArea status() {
		status = new JTextArea();
		
		TitledBorder border = new TitledBorder("Status");
		status.setBorder(border);
		
		status.setEditable(false);
		status.setText("Connection Status: ");
		
		return status;
	}

	private JComboBox<String> dropDown() {
		String[] items = {//"Transactions" ,
				"For sale", "For buy"};
		
		JComboBox<String> combo = new JComboBox<String>(items);
		
		return combo;
	}
	
	private JScrollPane dataTable() {
		String[] columnNames = {"ID", "Company", "number", "value"};
		Object[][] data = { {"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""}
		};
		JTable table = new JTable(data, columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		//table.setFillsViewportHeight(true);
		
		return scrollPane;
	}
}
