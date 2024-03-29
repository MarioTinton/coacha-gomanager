// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.coacha.gomanager.web;

import com.coacha.gomanager.model.GameResult;
import com.coacha.gomanager.model.Player;
import com.coacha.gomanager.web.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<GameResult, String> ApplicationConversionServiceFactoryBean.getGameResultToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.coacha.gomanager.model.GameResult, java.lang.String>() {
            public String convert(GameResult gameResult) {
                return new StringBuilder().append(gameResult.getWinnerColor()).append(' ').append(gameResult.getLoserColor()).append(' ').append(gameResult.getBlackStoneHandicap()).append(' ').append(gameResult.getPointHandicap()).toString();
            }
        };
    }
    
    public Converter<Long, GameResult> ApplicationConversionServiceFactoryBean.getIdToGameResultConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.coacha.gomanager.model.GameResult>() {
            public com.coacha.gomanager.model.GameResult convert(java.lang.Long id) {
                return GameResult.findGameResult(id);
            }
        };
    }
    
    public Converter<String, GameResult> ApplicationConversionServiceFactoryBean.getStringToGameResultConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.coacha.gomanager.model.GameResult>() {
            public com.coacha.gomanager.model.GameResult convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), GameResult.class);
            }
        };
    }
    
    public Converter<Long, Player> ApplicationConversionServiceFactoryBean.getIdToPlayerConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.coacha.gomanager.model.Player>() {
            public com.coacha.gomanager.model.Player convert(java.lang.Long id) {
                return Player.findPlayer(id);
            }
        };
    }
    
    public Converter<String, Player> ApplicationConversionServiceFactoryBean.getStringToPlayerConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.coacha.gomanager.model.Player>() {
            public com.coacha.gomanager.model.Player convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Player.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getGameResultToStringConverter());
        registry.addConverter(getIdToGameResultConverter());
        registry.addConverter(getStringToGameResultConverter());
        registry.addConverter(getPlayerToStringConverter());
        registry.addConverter(getIdToPlayerConverter());
        registry.addConverter(getStringToPlayerConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
