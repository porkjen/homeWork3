package com.systex.service;

public class GuessGame {
	private int remains;
	private int luckyNumber;
	
	public GuessGame(int range, int remains) {
		this.remains = remains;
		this.luckyNumber = (int)(Math.random()*range)+1;
	}
	
	public boolean guess(int number) {
		remains--;
		if(number == luckyNumber)return true;
		else return false;
	}
	
	public int getRemains() {
		return remains;
	}
	public int getLuckyNumber() {
		return luckyNumber;
	}

}
