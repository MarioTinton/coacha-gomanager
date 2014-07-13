// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.coacha.gomanager.model;

import com.coacha.gomanager.model.GameResult;
import com.coacha.gomanager.model.Player;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect GameResult_Roo_Finder {
    
    public static Long GameResult.countFindGameResultsByWinnerOrLoser(Player winner, Player loser) {
        if (winner == null) throw new IllegalArgumentException("The winner argument is required");
        if (loser == null) throw new IllegalArgumentException("The loser argument is required");
        EntityManager em = GameResult.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM GameResult AS o WHERE o.winner = :winner OR o.loser = :loser", Long.class);
        q.setParameter("winner", winner);
        q.setParameter("loser", loser);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<GameResult> GameResult.findGameResultsByWinnerOrLoser(Player winner, Player loser) {
        if (winner == null) throw new IllegalArgumentException("The winner argument is required");
        if (loser == null) throw new IllegalArgumentException("The loser argument is required");
        EntityManager em = GameResult.entityManager();
        TypedQuery<GameResult> q = em.createQuery("SELECT o FROM GameResult AS o WHERE o.winner = :winner OR o.loser = :loser", GameResult.class);
        q.setParameter("winner", winner);
        q.setParameter("loser", loser);
        return q;
    }
    
    public static TypedQuery<GameResult> GameResult.findGameResultsByWinnerOrLoser(Player winner, Player loser, String sortFieldName, String sortOrder) {
        if (winner == null) throw new IllegalArgumentException("The winner argument is required");
        if (loser == null) throw new IllegalArgumentException("The loser argument is required");
        EntityManager em = GameResult.entityManager();
        String jpaQuery = "SELECT o FROM GameResult AS o WHERE o.winner = :winner OR o.loser = :loser";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<GameResult> q = em.createQuery(jpaQuery, GameResult.class);
        q.setParameter("winner", winner);
        q.setParameter("loser", loser);
        return q;
    }
    
}
