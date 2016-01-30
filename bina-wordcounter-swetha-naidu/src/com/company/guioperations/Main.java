package com.company.guioperations;
/*
 * This class represents the main class.
 * Here, the user can select the file, read from the file and display the word-count in the file.
 * There are four GUI components TextArea, a button for reading file, a button for displaying the word-count. 
 */


import java.awt.EventQueue;
import java.awt.Image;
import com.company.operations.WordCounter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.File;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JLabel;

public class Main {
	private static final Logger log=Logger.getLogger(Main.class);
	//these are private variables representing the frame, textArea, textField.
	private JFrame frmWordCounterApplication;// represents frame
	private JTextArea textArea;//represents textArea
	private JTextField textField;//represents textField2
	private int textcontent;//represents textcontent
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					//this sets the frame to visible
					window.frmWordCounterApplication.setVisible(true);
				} catch (Exception e) {
					log.error("Exceptions happen! "+e);
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWordCounterApplication = new JFrame();
		frmWordCounterApplication.setTitle("Word Counter Application");
		frmWordCounterApplication.setBackground(Color.MAGENTA);
		frmWordCounterApplication.getContentPane().setBackground(SystemColor.control);
		frmWordCounterApplication.setBounds(100, 100, 397, 256);
		frmWordCounterApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWordCounterApplication.getContentPane().setLayout(null);
		//this creates a new button and displays the string on the invoked box.
		JButton btnOpen = new JButton("read file");
		btnOpen.addActionListener(new ActionListener() {
			/**
			 * this function is called whenever the read-file button is clicked.
			 */
			public void actionPerformed(ActionEvent arg0) {
				log.info("The user clicked the read-file button ");
				//This is used for letting the user to choose a file.
				JFileChooser fs=new JFileChooser(new File("C:\\"));
				//this is used for setting the text to the box that appears after clicking the readfile button
				fs.setDialogTitle("open a file");
				//this is used for setting the file filters  text and readme as the program should not let reading from all other type of files.
				fs.setFileFilter(new FileTypeFilters(".txt","Text File"));
				fs.setFileFilter(new FileTypeFilters(".md","ReadMe File"));
				//setLineWrap lets the text to wrap around the textArea
				textArea.setLineWrap(true);
				int result=fs.showOpenDialog(null);
				if(result==JFileChooser.APPROVE_OPTION){
					log.info("The user made a selection of the file. ");
					//this command reads the file 
					try{
					File fi=fs.getSelectedFile();
					log.info("The selected file is "+fi.getPath());
					if(fi.getPath()!=null&&!(fi.getPath().endsWith(".txt")||fi.getPath().endsWith(".md")))
					{
						System.out.println("The entered file extension is not valid. Only txt and md extensions are supported!");
						throw new Exception("The entered file extension is not valid. Only txt and md extensions are supported!");	
					}
					log.info(" The entered file extension is supported. "+fi.getPath());
					WordCounter wordcounter=new WordCounter(fi.getPath());		
						//the count of words is returned into textcontent.
						textcontent=wordcounter.getwordcount(fi.getPath());
						String fileContent=wordcounter.getfilecontent();
						//this is used to set the text to the textArea
						textArea.setText(fileContent);
						log.info("The file content is set to the textArea field on the GUI");
						//this is used to set the integer to the second textfield
						textField.setText(Integer.toString(textcontent));
						log.info("The number of valid English words is displayed in the second textField on the GUI");
						log.info("The program is successful");
					} 
					catch (Exception e) 
					{
						log.error("Exceptions happen! "+e);
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
				}
			}
		});
		/**
		 * these are used to set the design parameters to the gui components		
		 */
		
		btnOpen.setBackground(UIManager.getColor("Button.background"));
		btnOpen.setForeground(Color.BLACK);
		btnOpen.setBounds(159, 15, 89, 23);
		frmWordCounterApplication.getContentPane().add(btnOpen);
		
		JButton btnNumberOfWords = new JButton("valid words");
		btnNumberOfWords.setForeground(Color.BLACK);
		btnNumberOfWords.setBackground(UIManager.getColor("Button.background"));
		
		
		btnNumberOfWords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNumberOfWords.setBounds(159, 171, 109, 29);
		frmWordCounterApplication.getContentPane().add(btnNumberOfWords);
		//this is used to create a new textField.
		textField = new JTextField();
		textField.setBackground(UIManager.getColor("TextField.background"));
		textField.setBounds(289, 172, 54, 26);
		frmWordCounterApplication.getContentPane().add(textField);
		textField.setColumns(10);
		//this is used to create a new textArea
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setSize(200, 300);
		textArea.setTabSize(6);
		textArea.setBounds(1, 1, 104, 126);
		frmWordCounterApplication.getContentPane().add(textArea);
		//this initializes the scrollpane
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(159, 49, 184, 101);
		frmWordCounterApplication.getContentPane().add(scrollPane);
		
		label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/fitbina")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(29, 15, 104, 99);
		frmWordCounterApplication.getContentPane().add(label);
	}
}
