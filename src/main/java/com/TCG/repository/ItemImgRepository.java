package com.TCG.repository;

import com.TCG.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {

    ItemImg findByItemId(Long itemId);
}
