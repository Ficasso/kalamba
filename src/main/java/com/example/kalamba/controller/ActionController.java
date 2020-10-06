package com.example.kalamba.controller;

import com.example.kalamba.model.Action;
import com.example.kalamba.model.ActionEntity;
import com.example.kalamba.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(path = "/actions")
public class ActionController {

    @Autowired
    private ActionRepository actionRepository;

    @PostMapping("/addAction")
    public void addNewAction(@RequestParam String userId,
                               @RequestParam String gameId,
                               @RequestParam String actionName) {

        if (Arrays.stream(Action.values()).anyMatch(a -> a.name().equals(actionName))) {
            ActionEntity action = new ActionEntity();
            action.setUserId(Integer.parseInt(userId));
            action.setGameId(Integer.parseInt(gameId));
            var parsedAction = Action.valueOf(actionName);
            action.setAction(parsedAction);
            actionRepository.save(action);
        }
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