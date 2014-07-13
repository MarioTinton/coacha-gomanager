package com.coacha.gomanager.model;
import javax.persistence.Transient;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ExtraField {

    /**
     */
    private String fieldName;

    /**
     */
    private String fieldData;

    /**
     */
    @Transient
    private Integer remove;
}
