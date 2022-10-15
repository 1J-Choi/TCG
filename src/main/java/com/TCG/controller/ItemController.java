package com.TCG.controller;

import com.TCG.Dto.ItemFormDto;
import com.TCG.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping(value = "item/new")
    public String itemForm(Model model){
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "item.itemForm";
    }

    @PostMapping(value = "item/new")
    public String itemNew(@Valid ItemFormDto itemFormDto, BindingResult bindingResult, Model model,
                          @RequestParam("itemImgFile") MultipartFile itemImgFile){
        if(bindingResult.hasErrors()){
            return "item/itemForm";
        }

        if(itemImgFile.isEmpty() && itemFormDto.getId() == null){
            model.addAttribute("errorMessage",
                    "카드 이미지는 필수 입력 값입니다.");
            return "item/itemForm";
        }

        try{
            itemService.saveItem(itemFormDto, itemImgFile);
        }catch (Exception e){
            model.addAttribute("errorMessage", "상품 등록 중 에러가 발생하였습니다.");
            return "item/itemForm";
        }

        return "redirect:/";
    }

    @GetMapping(value = "item/{item_id}")
    public String itemDtl(@PathVariable("item_id")Long itemId, Model model){
        try {
            ItemFormDto itemFormDto = itemService.getitemFormDto(itemId);
            model.addAttribute("itemFormDto", itemFormDto);
        }catch (Exception e){
            model.addAttribute("errorMessage", "존재하지 않는 상품입니다.");
            model.addAttribute("itemFormDto", new ItemFormDto());
            return "item/itemForm";
        }
        return "item/itemForm";
    }

    @PostMapping(value = "item/{item_id}")
    public String itemUpdate(@Valid ItemFormDto itemFormDto, BindingResult bindingResult,
                                  @RequestParam("itemImgFile") MultipartFile itemImgFile,
                                  Model model){
        if (bindingResult.hasErrors()) {
            return "item/itemForm";
        }
        if (itemImgFile.isEmpty() && itemFormDto.getId() == null) {
            model.addAttribute("errorMessage",
                    "카드 이미지는 필수 입력 값입니다.");
            return "queBundle/queBundleForm";
        }
        try {
            itemService.updateItem(itemFormDto, itemImgFile);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "상품 수정 중 에러가 발생하였습니다.");
            return "item/itemForm";
        }
        return "redirect:/";
    }
}
