package com.coacha.gomanager.model;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findPlayersByTop" })
public class Player {

    /**
     */
    private String kanjiName;

    /**
     */
    @NotNull
    private String hiraganaName;

    /**
     */
    @NotNull
    private String romajiName;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @NotNull
    private Date birthday;

    /**
     */
    @NotNull
    private String nationality;

    @Transient
    private String top;

    @OneToOne(targetEntity = ExtraFieldObject.class, fetch = FetchType.EAGER, cascade = { javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.MERGE })
    private ExtraFieldObject extraFieldObject = new ExtraFieldObject();
    
    public static Long countFindPlayersByTop(String top) {
        EntityManager em = Player.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Player AS o WHERE 1 = 1", Long.class);
        q.setParameter("top", top);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<Player> findPlayersByTop(String top) {
        EntityManager em = Player.entityManager();
        TypedQuery<Player> q = em.createQuery("SELECT o FROM Player AS o WHERE 1 = 1", Player.class);
        q.setParameter("top", top);
        return q;
    }
    
    public static TypedQuery<Player> findPlayersByTop(String top, String sortFieldName, String sortOrder) {
        EntityManager em = Player.entityManager();
        String jpaQuery = "SELECT o FROM Player AS o WHERE 1 = 1";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Player> q = em.createQuery(jpaQuery, Player.class);
        q.setParameter("top", top);
        return q;
    }
    
}
