/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameFrames;

import raw.BetterGrid;
import raw.BetterTile;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Danshil K Mungur
 */
public class TestClass extends JFrame{
	private BetterGrid panel = new BetterGrid();

	/**
	 * Constructs a new frame that is initially invisible.
	 * This constructor sets the component's locale property to the value
	 * returned by <code>JComponent.getDefaultLocale</code>.
	 *
	 * @throws HeadlessException if GraphicsEnvironment.isHeadless() returns true.
	 * @see GraphicsEnvironment#isHeadless
	 * @see Component#setSize
	 * @see Component#setVisible
	 * @see JComponent#getDefaultLocale
	 */
	public TestClass() throws HeadlessException {
		run();
	}

	public static void main(String[] args) {
		TestClass test = new TestClass();
		test.setVisible(true);
	}
	
	public void run() {

		panel.setGridBackground();
		panel.initialiseButtons();
		panel.setGridLayout();
//		panel.generateRandomLetters();
//		panel.populateGrid();

		add(panel);

		setTitle("Simple example");
		setSize(220, 220);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


	}
}
