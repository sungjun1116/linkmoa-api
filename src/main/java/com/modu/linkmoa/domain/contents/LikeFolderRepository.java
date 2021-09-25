package com.modu.linkmoa.domain.contents;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeFolderRepository extends JpaRepository<LikeFolder, Long> {
}
