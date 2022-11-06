package com.TCG.Dto;

import com.TCG.constant.CardProp;
import com.TCG.constant.CardRace;
import com.TCG.constant.CardType;
import com.TCG.constant.ItemSellStatus;
import com.TCG.entity.Item;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ItemFormDto {

    private Long id;

    @NotBlank(message = "카드 이름은 필수 입력 값입니다.")
    private String CardName;
    private CardType cardType;
    private CardRace cardRace;
    private CardProp cardProp;

    private int level;
    private int rank;

    private int atk;
    private int def;

    private int count;

    private int cost;

    private String detail;

    private Long itemImgId;

    private ItemSellStatus itemSellStatus;

    private static ModelMapper modelMapper = new ModelMapper();

    public Item createItem() {

        return modelMapper.map(this, Item.class); // ItemFormDto -> Item 연결
    }

    public static ItemFormDto of(Item item) {

        return modelMapper.map(item, ItemFormDto.class); // Item -> ItemFormDto 연결
    }
}
