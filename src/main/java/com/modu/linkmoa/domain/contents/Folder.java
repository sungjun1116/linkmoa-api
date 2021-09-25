package com.modu.linkmoa.domain.contents;

import com.modu.linkmoa.domain.BaseTimeEntity;
import com.modu.linkmoa.domain.StatusType;
import com.modu.linkmoa.domain.category.Category;
import com.modu.linkmoa.domain.category.DetailCategory;
import com.modu.linkmoa.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "FolderDetail")
@Entity
public class Folder extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folderIdx")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryIdx")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detailCategoryIdx")
    private DetailCategory detailCategory;

    @Column(name = "folderName")
    private String name;

    @Enumerated(EnumType.STRING)
    private FolderType folderType;

    @Enumerated
    private StatusType status;

    @Builder
    public Folder(User user, Category category, DetailCategory detailCategory, String name, FolderType folderType) {
        this.user = user;
        this.category = category;
        this.detailCategory = detailCategory;
        this.name = name;
        this.folderType = folderType;
    }
}