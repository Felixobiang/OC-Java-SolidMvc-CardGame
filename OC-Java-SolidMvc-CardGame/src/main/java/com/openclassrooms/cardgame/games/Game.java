package com.openclassrooms.cardgame.games;

import com.openclassrooms.cardgame.controller.GameController;

import com.openclassrooms.cardgame.model.DeckFactory;
import com.openclassrooms.cardgame.model.DeckFactory.DeckType;
import com.openclassrooms.cardgame.view.GameSwingPassiveView;
import com.openclassrooms.cardgame.view.GameSwingView;
import com.openclassrooms.cardgame.view.GameViewables;

public class Game {
	
	public static void main(String[] args) {
		
		GameViewables views = new GameViewables();
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();
		views.addViewable(gsv);
		
		for(int i = 0; i< 3; i++) {
			GameSwingPassiveView passiveView = new GameSwingPassiveView();
			passiveView.createAndShowGUI();
			
			views.addViewable(passiveView);
			
			// sleep to move new Swing frame on window
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		GameController gc = new GameController(DeckFactory.makeDeck(DeckType.Normal), views, new HighCardGameEvaluator() );
		//GameController gc = new GameController(new Deck(), new View(), new LowCardGameEvaluator() );
		gc.run();

	}

}
