package com.coacha.gomanager.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

import com.coacha.gomanager.model.Player;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}
	
    public Converter<Player, String> getPlayerToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.coacha.gomanager.model.Player, java.lang.String>() {
            @Override
			public String convert(Player player) {
                return new StringBuilder().append(player.getKanjiName()).append(' ').append(player.getHiraganaName()).append(' ').append(player.getRomajiName()).toString();
            }
        };
    }    

}
