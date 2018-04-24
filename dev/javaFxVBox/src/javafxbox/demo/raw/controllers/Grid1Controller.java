/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbox.demo.raw.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafxbox.demo.raw.OneGrid;
import javafxbox.demo.raw.PositionInGrid;
import javafxbox.demo.raw.SomeTile;
import javafxbox.demo.raw.interfaces.Grid;
import javafxbox.demo.raw.interfaces.Tile;

/**
 *
 * @author Danshil K Mungur
 */
public class Grid1Controller implements Initializable{

	@FXML private SomeTile R0C0 = new SomeTile(new PositionInGrid(0, 0));
	@FXML private SomeTile R0C1 = new SomeTile(new PositionInGrid(0, 1));
	@FXML private SomeTile R0C2 = new SomeTile(new PositionInGrid(0, 2));
	@FXML private SomeTile R1C0 = new SomeTile(new PositionInGrid(1, 0));
	@FXML private SomeTile R1C1 = new SomeTile(new PositionInGrid(1, 1));
	@FXML private SomeTile R1C2 = new SomeTile(new PositionInGrid(1, 2));
	@FXML private SomeTile R2C0 = new SomeTile(new PositionInGrid(2, 0));
	@FXML private SomeTile R2C1 = new SomeTile(new PositionInGrid(2, 1));
	@FXML private SomeTile R2C2 = new SomeTile(new PositionInGrid(2, 2));
	@FXML private OneGrid grid1 = new OneGrid(1);

	List<SomeTile> allTiles = new ArrayList<>(Arrays.asList(R0C0, R0C1, R0C2, R1C0, R1C1, R1C2, R2C0, R2C1, R2C2));
	SomeTile clickedTile = new SomeTile();

	/**
	 * This has to get the random list of alphabets and set the buttons to it in the grid
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//		alButtons.addAll(Arrays.asList(R0C0, R0C1, R0C2, R1C0, R1C1, R1C2, R2C0, R2C1, R2C2));
		grid1.setGeneratedLetters(allTiles);
	}

	/**
	 * This is called whenever a tile is clicked on
	 * It sets the valid neighbouring tiles as selectable
	 * @param event
	 */
	public void handleTileAction(ActionEvent event) {
		clickedTile = (SomeTile) event.getSource();
		int originRow = clickedTile.getRowNoInGrid();
		int originCol = clickedTile.getColNoInGrid();
		// get grid here

		int row = originRow;
		int col = originCol;
		int posX = row;
		int posY = col;

		// Only tiles that are selectable will have their neighbours marked as selectable
		// Else print warning in the console for the moment being
		if (clickedTile.isSelectable()) {
			clickedTile.select();

			// set all tiles selectable to false first
			// this includes the clicked tile since it should not be able to be selected again
			for (SomeTile tile : allTiles) {
				tile.setSelectable(false);
			}

			// this is to set all the neighbours selectable to true
			// so that the player can select another tile after
			while (row >= posY && row <= originCol + 1) {
				if (row >= 0 && row <= 2) {
					while (col >= posX && col <= originRow + 1) {
						// make sure not out of bounds of box
						if (col >= 0 && col <= 2) {
							if (!(row == originCol && col == originRow)) {
								if (row == 0) {
									if (col == 0) {
										R0C0.setSelectable(true);
									} else if (col == 1) {
										R0C1.setSelectable(true);
									} else if (col == 2) {
										R0C2.setSelectable(true);
									}
								} else if (row == 1) {
									if (col == 0) {
										R1C0.setSelectable(true);
									} else if (col == 1) {
										R1C1.setSelectable(true);
									} else if (col == 2) {
										R1C2.setSelectable(true);
									}
								} else if (row == 2) {
									if (col == 0) {
										R2C0.setSelectable(true);
									} else if (col == 1) {
										R2C1.setSelectable(true);
									} else if (col == 2) {
										R2C2.setSelectable(true);
									}
								}
							}
						}
						col++;
					}
				}
				// start at initial value again in new row
				col = posX;
				row++;
			}
		} else {
			System.out.println("Cannot select this tile");
		}

	}
}
