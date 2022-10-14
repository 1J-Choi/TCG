package com.TCG.constant;

import lombok.Getter;

@Getter
public enum CardProp {
    DARK("어둠"),
    LIGHT("빛"),
    EARTH("땅"),
    WATER("물"),
    FIRE("불"),
    FLAME("화염"),
    WIND("바람"),
    GOD("신");

    private String krName;
    CardProp(String krName){ this.krName = krName; }
}
