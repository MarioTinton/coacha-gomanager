// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.coacha.gomanager.model;

import com.coacha.gomanager.model.GameResult;
import com.coacha.gomanager.model.Player;
import java.util.Date;

privileged aspect GameResult_Roo_JavaBean {
    
    public Player GameResult.getWinner() {
        return this.winner;
    }
    
    public void GameResult.setWinner(Player winner) {
        this.winner = winner;
    }
    
    public Player GameResult.getLoser() {
        return this.loser;
    }
    
    public void GameResult.setLoser(Player loser) {
        this.loser = loser;
    }
    
    public Short GameResult.getWinnerColor() {
        return this.winnerColor;
    }
    
    public void GameResult.setWinnerColor(Short winnerColor) {
        this.winnerColor = winnerColor;
    }
    
    public Short GameResult.getLoserColor() {
        return this.loserColor;
    }
    
    public void GameResult.setLoserColor(Short loserColor) {
        this.loserColor = loserColor;
    }
    
    public Integer GameResult.getBlackStoneHandicap() {
        return this.blackStoneHandicap;
    }
    
    public void GameResult.setBlackStoneHandicap(Integer blackStoneHandicap) {
        this.blackStoneHandicap = blackStoneHandicap;
    }
    
    public Integer GameResult.getPointHandicap() {
        return this.pointHandicap;
    }
    
    public void GameResult.setPointHandicap(Integer pointHandicap) {
        this.pointHandicap = pointHandicap;
    }
    
    public Integer GameResult.getFinalScoreDifference() {
        return this.finalScoreDifference;
    }
    
    public void GameResult.setFinalScoreDifference(Integer finalScoreDifference) {
        this.finalScoreDifference = finalScoreDifference;
    }
    
    public Date GameResult.getGameDate() {
        return this.gameDate;
    }
    
    public void GameResult.setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }
    
}
