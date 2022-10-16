package com.TCG.entity;

import com.TCG.Dto.ItemFormDto;
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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

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

    public void updateItem(ItemFormDto itemFormDto){
        this.cardName = itemFormDto.getCardName();
        this.cardProp = itemFormDto.getCardProp();
        this.cardRace = itemFormDto.getCardRace();
        this.cardType = itemFormDto.getCardType();
        this.level = itemFormDto.getLevel();
        this.rank = itemFormDto.getRank();
        this.atk = itemFormDto.getAtk();
        this.def = itemFormDto.getDef();
        this.count = itemFormDto.getCount();
        this.cost = itemFormDto.getCost();
        this.detail = itemFormDto.getDetail();
    }
}
