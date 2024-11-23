package com.example.stock_game.Models;

public class User {
    private String userID;
    private double balance;
    private Portfolio portfolio;

    public User(String userID, double balance, Portfolio portfolio) {
        this.userID = userID;
        this.balance = balance;
        this.portfolio = portfolio;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

}
