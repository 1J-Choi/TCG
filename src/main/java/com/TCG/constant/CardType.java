package com.TCG.constant;

import lombok.Getter;

@Getter
public enum CardType {

    MONSTER("몬스터"), MAGIC("마법"), TRAP("함정");
    private String krName;
    CardType(String krName){ this.krName = krName; }
}
