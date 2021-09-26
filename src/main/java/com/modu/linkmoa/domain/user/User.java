package com.modu.linkmoa.domain.user;

import com.modu.linkmoa.domain.BaseTimeEntity;
import com.modu.linkmoa.domain.StatusType;
import com.modu.linkmoa.domain.category.Category;
import com.modu.linkmoa.domain.category.DetailCategory;
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

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userIdx")
    private Long id;

    @Column(name = "userStrategy")
    @Enumerated(EnumType.STRING)
    private Strategy strategy;

    @Column(name = "socialId")
    private String socialId;

    @Column(name = "userNickname")
    private String nickname;

    @Column(name = "userEmail")
    private String email;

    @Column(name = "userProfileImgUrl", columnDefinition = "TEXT")
    private String profileImgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryIdx")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detailCategoryIdx")
    private DetailCategory detailCategory;

    // 추후 DB 칼럼 체계화 작업 진행 후 EnumType.String 으로 변경
    @Enumerated
    private StatusType status;

    @Builder
    public User(Long id, Strategy strategy, String socialId, String email) {
        this.id = id;
        this.strategy = strategy;
        this.socialId = socialId;
        this.email = email;
    }

    /**
     * 추가정보 등록
     */
    public void update(String nickname, Category category, DetailCategory detailCategory) {
        this.nickname = nickname;
        this.category = category;
        this.detailCategory = detailCategory;
    }

}