package com.TCG.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item_img")
@Getter
@Setter
public class ItemImg {

    @Id
    @Column(name = "item_img")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String imgName; //이미지 파일명
    private String oriImgName; // 원본 이미지 파일명
    private String imgUrl;// 이미지 조회 경로

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public void updateQueBundleImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }
}
