package com.b2iapi.api;

import java.util.Map;

public enum Moves {
    ROCK("rock",0),
    PAPER("paper",1),
    SCISSORS("scissors",2);
    private final String name;
    private final int id;
    public static final Map<String,String> rules;
    static {
        rules = Map.of("rock", "scissors", "paper", "rock", "scissors", "paper");
    }

    Moves(String name, Integer id) {
        this.name=name;
        this.id=id;
    }
    public static int getId(String name){
        for(Moves var:Moves.values()){
            if(var.name.equals(name)){
                return var.id;
            }
        }
        return 0;
    }

    public static String getName(int id) {
        for(Moves var:Moves.values()){
            if(var.id==id){
                return var.name;
            }
        }
        return null;
    }
    public static boolean match(String choiceOne,String choiceTwo) {
        return rules.get(choiceOne.toLowerCase()).equalsIgnoreCase(choiceTwo);
    }
}
