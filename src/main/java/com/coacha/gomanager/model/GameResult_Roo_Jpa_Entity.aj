// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.coacha.gomanager.model;

import com.coacha.gomanager.model.GameResult;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect GameResult_Roo_Jpa_Entity {
    
    declare @type: GameResult: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long GameResult.id;
    
    @Version
    @Column(name = "version")
    private Integer GameResult.version;
    
    public Long GameResult.getId() {
        return this.id;
    }
    
    public void GameResult.setId(Long id) {
        this.id = id;
    }
    
    public Integer GameResult.getVersion() {
        return this.version;
    }
    
    public void GameResult.setVersion(Integer version) {
        this.version = version;
    }
    
}