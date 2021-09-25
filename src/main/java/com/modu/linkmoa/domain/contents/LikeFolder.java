package com.modu.linkmoa.domain.contents;

import com.modu.linkmoa.domain.BaseTimeEntity;
import com.modu.linkmoa.domain.StatusType;
import com.modu.linkmoa.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
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
public class LikeFolder extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folderIdx")
    private Folder folder;

    // 추후 DB 칼럼 체계화 작업 진행 후 EnumType.String 으로 변경
    @Enumerated
    private StatusType status;
}