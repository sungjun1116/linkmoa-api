package com.modu.linkmoa.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailCategoryRepository extends JpaRepository<DetailCategory, Integer> {
}
