package com.modu.linkmoa.domain.category;

import com.modu.linkmoa.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Category extends BaseTimeEntity {

    @Id
    @Column(name = "categoryIdx")
    private Integer id;

    @Column(name = "categoryName")
    private String name;

    @Builder
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}