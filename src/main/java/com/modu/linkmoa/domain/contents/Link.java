package com.modu.linkmoa.domain.contents;

import com.modu.linkmoa.domain.BaseTimeEntity;
import com.modu.linkmoa.domain.StatusType;
import com.modu.linkmoa.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
public class Link extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "linkIdx")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folderIdx")
    private Folder folder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    private String linkName;

    @Column(columnDefinition = "TEXT")
    private String linkUrl;

    @Column(columnDefinition = "TEXT")
    private String linkImageUrl;

    @Column(columnDefinition = "TEXT")
    private String linkFaviconUrl;

    @Enumerated
    private StatusType status;
}