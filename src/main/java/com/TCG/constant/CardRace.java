package com.TCG.constant;

import lombok.Getter;

@Getter
public enum CardRace {
    WIZARD("마법사족"),
    DRAGON("드래곤족"),
    UNDEAD("언데드족"),
    WARRIOR("전사족"),
    BWARRIOR("야수전사족"),
    BEAST("야수족"),
    FBEAST("비행야수족"),
    DEVIL("악마족"),
    ANGEL("천사족"),
    INSECT("곤충족"),
    DINO("공룡족"),
    REPTILE("파충류족"),
    FISH("어류족"),
    WDINO("해룡족"),
    WATER("물족"),
    FLAME("화염족"),
    LIGHTNING("번개족"),
    ROCK("암석족"),
    PLANT("식물족"),
    MECHA("기계족"),
    PSYCH("사이킥족"),
    DBEAST("환신야수족"),
    DDINO("환룡족"),
    CYBERS("사이버스족");

    private String krName;
    CardRace(String krName){ this.krName = krName; }
}
