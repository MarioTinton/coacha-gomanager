package com.coacha.gomanager.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.util.AutoPopulatingList;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ExtraFieldObject {

    @OneToMany(targetEntity=ExtraField.class, fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExtraField> extraFields = new AutoPopulatingList<ExtraField>(ExtraField.class);

}
