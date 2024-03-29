package com.coacha.gomanager.web;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coacha.gomanager.model.GameResult;
import com.coacha.gomanager.model.Player;

@RequestMapping("/gameresults")
@Controller
@RooWebScaffold(path = "gameresults", formBackingObject = GameResult.class)
@RooWebFinder
public class GameResultController {
	
    
    @RequestMapping(params = { "find=ByWinnerOrLoser", "form" }, method = RequestMethod.GET)
    public String findGameResultsByWinnerOrLoserForm(Model uiModel) {
        uiModel.addAttribute("players", Player.findAllPlayers());
        uiModel.addAttribute("players", Player.findAllPlayers());
        return "gameresults/findGameResultsByWinnerOrLoser";
    }
    
    @RequestMapping(params = "find=ByWinnerOrLoser", method = RequestMethod.GET)
    public String findGameResultsByWinnerOrLoser(@RequestParam("winner") Player winner, @RequestParam(value = "loser", required = false) Player loser, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
    	loser = winner;
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("gameresults", GameResult.findGameResultsByWinnerOrLoser(winner, loser, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) GameResult.countFindGameResultsByWinnerOrLoser(winner, loser) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("gameresults", GameResult.findGameResultsByWinnerOrLoser(winner, loser, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "gameresults/list";
    }
    
}
