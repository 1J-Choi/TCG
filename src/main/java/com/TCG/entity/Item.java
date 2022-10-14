package com.TCG.entity;

import com.TCG.constant.CardProp;
import com.TCG.constant.CardRace;
import com.TCG.constant.CardType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private String cardName; // 카드 이름
    @Enumerated(EnumType.STRING)
    private CardProp cardProp; // 카드 속성
    @Enumerated(EnumType.STRING)
    private CardRace cardRace; // 카드 종족
    @Enumerated(EnumType.STRING)
    private CardType cardType; // 카드 종류

    private int level;
    private int rank;

    private int atk;
    private int def;

    private int count;

    private int cost;

    private String detail;
}
