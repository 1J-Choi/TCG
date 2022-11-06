package com.TCG.Dto;

import com.TCG.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchDto {
    private String searchDateType;
    private ItemSellStatus searchSellStatus;
    private String SearchBy;
    private String searchQuery = "";
}
