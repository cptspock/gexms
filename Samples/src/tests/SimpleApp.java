package tests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleApp implements ActionListener{
	JFileChooser fileChooser;
	JFrame frame = new JFrame("HelloWorldSwing");

	public void createAndShowGUI() {
        //Create and set up the window.
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fileChooser = new JFileChooser();


        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label); 
        JButton browseButton = new JButton("Browse...");
        JFileChooser fileChooser;
        fileChooser = new JFileChooser();
        frame.getContentPane().add(browseButton);
        browseButton.addActionListener(this);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	public void actionPerformed(ActionEvent clicked){
        int returnVal = fileChooser.showOpenDialog(frame.getContentPane());

        
	}

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleApp().createAndShowGUI();
            }
        });
    }

}
