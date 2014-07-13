package com.coacha.gomanager.model;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findGameResultsByWinnerOrLoser", "findGameResultsByWinnerAndLoser" })
public class GameResult {

    /**
     */
    @ManyToOne
    @NotNull
    private Player winner;

    /**
     */
    @ManyToOne
    @NotNull
    private Player loser;

    /**
     */
    private Short winnerColor;

    /**
     */
    private Short loserColor;

    /**
     */
    private Integer blackStoneHandicap;

    /**
     */
    private Integer pointHandicap;

    /**
     */
    private Integer finalScoreDifference;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date gameDate;
    
    public static Long countFindGameResultsByWinnerAndLoser(Player winner, Player loser) {
        if (winner == null) throw new IllegalArgumentException("The winner argument is required");
        if (loser == null) throw new IllegalArgumentException("The loser argument is required");
        EntityManager em = GameResult.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM GameResult AS o WHERE (o.winner = :winner AND o.loser = :loser) OR (o.winner = :loser AND o.loser = :winner)", Long.class);
        q.setParameter("winner", winner);
        q.setParameter("loser", loser);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<GameResult> findGameResultsByWinnerAndLoser(Player winner, Player loser) {
        if (winner == null) throw new IllegalArgumentException("The winner argument is required");
        if (loser == null) throw new IllegalArgumentException("The loser argument is required");
        EntityManager em = GameResult.entityManager();
        TypedQuery<GameResult> q = em.createQuery("SELECT o FROM GameResult AS o WHERE (o.winner = :winner AND o.loser = :loser) OR (o.winner = :loser AND o.loser = :winner)", GameResult.class);
        q.setParameter("winner", winner);
        q.setParameter("loser", loser);
        return q;
    }
    
    public static TypedQuery<GameResult> findGameResultsByWinnerAndLoser(Player winner, Player loser, String sortFieldName, String sortOrder) {
        if (winner == null) throw new IllegalArgumentException("The winner argument is required");
        if (loser == null) throw new IllegalArgumentException("The loser argument is required");
        EntityManager em = GameResult.entityManager();
        String jpaQuery = "SELECT o FROM GameResult AS o WHERE (o.winner = :winner AND o.loser = :loser) OR (o.winner = :loser AND o.loser = :winner)";
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
