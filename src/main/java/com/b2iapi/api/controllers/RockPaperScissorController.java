package com.b2iapi.api.controllers;
import com.b2iapi.api.game.Moves;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping
public class RockPaperScissorController {
    @PostMapping(value="/play",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Object,String>>play (@RequestBody() String userInput,@RequestParam(defaultValue = "false") String explain){
        JsonParser parser = JsonParserFactory.getJsonParser();
        userInput=parser.parseMap(userInput).get("move").toString();
        Random random=new Random();
        Map<Object,String> output=new HashMap<>();
        int cpuChoice=random.nextInt(3);
        output.put(Moves.match(userInput, Moves.getName(cpuChoice)), Moves.getName(cpuChoice));
        if(explain.equalsIgnoreCase("true")){
            output.put(userInput, Moves.rules.get(userInput.toLowerCase()));
        }
        return ResponseEntity.ok(output);
    }
}
