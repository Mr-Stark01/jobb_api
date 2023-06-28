package com.b2iapi.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class RulesController {
    @GetMapping(value = {"/rules","/rules/{options}"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> rule(@PathVariable(required = false,name = "options") Optional<String> rulesOptions) {
        return ResponseEntity.ok(rulesOptions.filter(Moves.rules::containsKey).map(s -> Moves.rules.entrySet().stream()
                .filter(map -> s.equalsIgnoreCase(map.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))).orElse(Moves.rules));
    }
}
