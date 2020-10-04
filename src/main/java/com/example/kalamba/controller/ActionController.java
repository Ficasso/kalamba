package com.example.kalamba.controller;

import com.example.kalamba.model.Action;
import com.example.kalamba.model.ActionEntity;
import com.example.kalamba.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping(path = "/actions")
public class ActionController {

    @Autowired
    private ActionRepository actionRepository;

    @PostMapping("/addAction")
    public String addNewAction(@RequestParam String userId,
                               @RequestParam String gameId,
                               @RequestParam String actionName) {

        if (Arrays.stream(Action.values()).noneMatch(a -> a.name().equals(actionName))) {
            return "redirect:/actions/invalidAction";
        }
        ActionEntity action = new ActionEntity();
        action.setUserId(Integer.parseInt(userId));
        action.setGameId(Integer.parseInt(gameId));
        var parsedAction = Action.valueOf(actionName);
        action.setAction(parsedAction);
        actionRepository.save(action);
        return "redirect:/actions/allActions";
    }

    @GetMapping("/allActions")
    public @ResponseBody
    Iterable<ActionEntity> getAllActionsFromTable() {
        return actionRepository.findAll();
    }

    @GetMapping("/invalidAction")
    public @ResponseBody
    String getInvalidActionMessage() {
        return "Failed to add an action to table due to invalid action name";
    }
}