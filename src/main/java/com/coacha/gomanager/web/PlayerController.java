package com.coacha.gomanager.web;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coacha.gomanager.model.ExtraField;
import com.coacha.gomanager.model.ExtraFieldObject;
import com.coacha.gomanager.model.Player;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RequestMapping("/players")
@Controller
@RooWebScaffold(path = "players", formBackingObject = Player.class)
@RooWebFinder
public class PlayerController {

    // Manage dynamically added or removed extraFields
    private List<ExtraField> manageExtraFields(Player player) {
        // Store the extraFields which shouldn't be persisted
        List<ExtraField> extraFields2remove = new ArrayList<ExtraField>();
        if (player.getExtraFieldObject().getExtraFields() != null) {
            for (Iterator<ExtraField> i = player.getExtraFieldObject().getExtraFields().iterator(); i.hasNext(); ) {
                ExtraField extraField = i.next();
                // If the remove flag is true, remove the extraField from the list
                if (extraField.getRemove() == 1) {
                    extraFields2remove.add(extraField);
                    i.remove();
                }
            }
        }
        return extraFields2remove;
    }

    @RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        Player player = Player.findPlayer(id);
        uiModel.addAttribute("extraFieldObject", player == null ? null : player.getExtraFieldObject());
        uiModel.addAttribute("player", player);
        uiModel.addAttribute("itemId", id);
        return "players/show";
    }

    void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("player_birthday_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

    void populateEditForm(Model uiModel, Player player) {
        uiModel.addAttribute("player", player);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("extraFieldObject", new ExtraFieldObject());
        uiModel.addAttribute("extrafieldobjects", ExtraFieldObject.findAllExtraFieldObjects());
    }
}
