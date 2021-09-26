package com.modu.linkmoa.domain.category;

import com.modu.linkmoa.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class DetailCategory extends BaseTimeEntity {

    @Id
    @Column(name = "detailCategoryIdx")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryIdx")
    private Category category;

    @Column(name = "detailCategoryName")
    private String name;

    @Builder
    public DetailCategory(int id, Category category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
    }
}