package model;

/**
 * Created by Ramzan on 13/12/2016.
 */

public class SlotMachine {

	private static int wins, loses, bet, credit = 10, numberOfGames;

	// return the total winnings
	public int getWin() {
		return wins;
	}

	// return the total losses
	public int getLoses() {
		return loses;
	}

	// return the current bet amount
	public int getBet() {
		return bet;
	}

	// return the current remaining credits
	public int getCredit() {
		return credit;
	}

	// set the winnings
	public void setWin(int win) {
		SlotMachine.wins = win;
	}

	// set the losses
	public void setLoses(int loses) {
		SlotMachine.loses = loses;
	}

	// set the current bet
	public void setBet(int bet) {
		SlotMachine.bet = bet;
	}

	// set the current remaining credit amount
	public void setCredit(int credit) {
		SlotMachine.credit = credit;
	}

	// return the total number of games played
	public int getNumberOfGames() {
		return numberOfGames;
	}

	// set the total number of games played
	public void setNumberOfGames(int numberOfGames) {
		SlotMachine.numberOfGames = numberOfGames;
	}

}
