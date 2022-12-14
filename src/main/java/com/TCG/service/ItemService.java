package com.TCG.service;

import com.TCG.Dto.ItemFormDto;
import com.TCG.Dto.ItemImgDto;
import com.TCG.Dto.ItemSearchDto;
import com.TCG.Dto.MainItemDto;
import com.TCG.entity.Item;
import com.TCG.entity.ItemImg;
import com.TCG.repository.ItemImgRepository;
import com.TCG.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemImgService itemImgService;
    private final ItemImgRepository itemImgRepository;

    public Long saveItem(ItemFormDto itemFormDto, MultipartFile itemImgFile) throws Exception{
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        ItemImg itemImg = new ItemImg();
        itemImg.setItem(item);
        itemImgService.saveItemImg(itemImg, itemImgFile);

        return item.getId();
    }

    @Transactional(readOnly = true) // 읽기 전용 -> 더티체킹(변경 감지) -> 성능 향상상
    public ItemFormDto getItemDtl(Long itemId) {
        ItemImg itemImg = itemImgRepository.findByItemId(itemId); // DB에서 데이터를 가져온다

        // Item 엔티티 조회 -> 조회X EntityNotFoundException 실행
        Item item = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
        ItemFormDto itemFormDto = ItemFormDto.of(item);
        itemFormDto.setItemImgId(itemImg.getId());
        return itemFormDto;
    }
    @Transactional(readOnly = true)
    public ItemFormDto getitemFormDto(Long itemId){
        Item item = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
        ItemFormDto itemFormDto = ItemFormDto.of(item);
        return itemFormDto;
    }


    public Long updateItem(ItemFormDto itemFormDto, MultipartFile itemImgFile) throws Exception{
        Item item = itemRepository.findById(itemFormDto.getId()).orElseThrow(EntityNotFoundException::new);
        item.updateItem(itemFormDto);
        Long itemImgId = itemFormDto.getItemImgId();
        itemImgService.updateItemImg(itemImgId, itemImgFile);

        return item.getId();
    }

//    @Transactional(readOnly = true)
//    public Page<Item> getAdminitemPage(ItemSearchDto itemSearchDto, Pageable pageable){
//        return itemRepository.getAdminitemPage(itemSearchDto, pageable);
//    }
    public void deleteItem(Long itemId){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(EntityExistsException::new);
        itemRepository.delete(item);
    }


    public List<String> itemNmList(){
        return itemRepository.findAllItemName();
    }


    @Transactional(readOnly = true) //메인 화면 노출
    public Page<MainItemDto> getMainitemPage(ItemSearchDto itemSearchDto, Pageable pageable){
        return itemRepository.getMainItemPage(itemSearchDto, pageable);
    }
}
