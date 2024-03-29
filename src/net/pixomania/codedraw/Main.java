/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on 2011-apr-29, 10:06:40
 */
package net.pixomania.codedraw;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

/**
 * @author galaxyAbstractor
 */
public class Main extends javax.swing.JFrame {

	static {
		System.setProperty("swing.defaultlaf", "org.pushingpixels.substance.api.skin.SubstanceGeminiLookAndFeel");
	}

	/** Creates new form Main */
	public Main() {
		initComponents();

	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		canvas1 = new CodeCanvas();
		jToolBar1 = new javax.swing.JToolBar();
		saveButton = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(500, 500));
		setResizable(false);

		jPanel1.setPreferredSize(new java.awt.Dimension(657, 250));

		jToolBar1.setFloatable(false);
		jToolBar1.setRollover(true);

		saveButton.setText("Save");
		saveButton.setFocusable(false);
		saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveButtonActionPerformed(evt);
			}
		});
		jToolBar1.add(saveButton);

		jButton2.setText("Load");
		jButton2.setFocusable(false);
		jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton2);

		jScrollPane1.setPreferredSize(new java.awt.Dimension(166, 250));

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextArea1KeyReleased(evt);
			}
		});
		jScrollPane1.setViewportView(jTextArea1);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
										.addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
		);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)
								.addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(0, 0, 0)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0))
		);

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 845) / 2, (screenSize.height - 538) / 2, 845, 538);
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Add the color to the list and repaint the canvas
	 * @param evt
	 */
	private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
		// Convert the characters of the text to Decimals
		CodeCanvas.addColor(TextToDecFormatter.getList(jTextArea1.getText()));
		canvas1.repaint();
	}//GEN-LAST:event_jTextArea1KeyReleased

	/**
	 * Save the image to a file
	 * @param evt
	 */
	private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

		// Create an image from the ints
		final BufferedImage img = CreateImage.create(TextToDecFormatter.getList(jTextArea1.getText()));
		final JFrame frame = new JFrame("Choose files");

		JFileChooser filechooser = new JFileChooser();
		filechooser.setDialogType(JFileChooser.SAVE_DIALOG);
		filechooser.setSelectedFile(new File("file.bmp"));
		filechooser.setFileFilter(new FileFilter() {
			@Override
			public boolean accept(File f) {
				return f.toString().endsWith(".bmp");
			}

			@Override
			public String getDescription() {
				return ".bmp";
			}
		});
		filechooser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "CancelSelection") {
					frame.dispose();
				} else if (e.getActionCommand() == "ApproveSelection") {
					JFileChooser fc = (JFileChooser) e.getSource();

					try {
						// Save it to a file
						ImageIO.write(img, "bmp", fc.getSelectedFile());
						frame.dispose();
					} catch (IOException ex) {
						Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
					}

				}

			}
		});


		frame.add(filechooser);
		frame.pack();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;

		frame.setLocation(x, y);
		frame.setVisible(true);


	}//GEN-LAST:event_saveButtonActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
