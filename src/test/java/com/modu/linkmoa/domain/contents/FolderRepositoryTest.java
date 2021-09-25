package com.modu.linkmoa.domain.contents;

import com.modu.linkmoa.domain.category.Category;
import com.modu.linkmoa.domain.category.CategoryRepository;
import com.modu.linkmoa.domain.category.DetailCategory;
import com.modu.linkmoa.domain.category.DetailCategoryRepository;
import com.modu.linkmoa.domain.user.Strategy;
import com.modu.linkmoa.domain.user.User;
import com.modu.linkmoa.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class FolderRepositoryTest {

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    DetailCategoryRepository detailCategoryRepository;

    @AfterEach
    public void cleanup() {
        folderRepository.deleteAll();
    }

    @Test
    @DisplayName("등록")
    public void save() throws Exception {

        // given
        User user = createUser();
        Category category = createCategory();
        DetailCategory detailCategory = createDetailCategory(category);
        String name = "황성준";
        FolderType folderType = FolderType.PUBLIC;

        folderRepository.save(Folder.builder()
                .user(user)
                .category(category)
                .detailCategory(detailCategory)
                .name(name)
                .folderType(folderType)
                .build());

        // when
        List<Folder> folderList = folderRepository.findAll();

        // then
        Folder folder = folderList.get(0);
        assertThat(folder.getUser()).isEqualTo(user);
        assertThat(folder.getCategory()).isEqualTo(category);
        assertThat(folder.getDetailCategory()).isEqualTo(detailCategory);
        assertThat(folder.getName()).isEqualTo(name);
        assertThat(folder.getFolderType()).isEqualTo(folderType);
    }

    private User createUser() {
        User user = User.builder()
                .strategy(Strategy.APPLE)
                .socialId("107851073233461381620")
                .email("opr99@naver.com")
                .build();
        userRepository.save(user);
        return user;
    }

    private Category createCategory() {
        Category category =  Category.builder()
                .id(1)
                .name("개발")
                .build();
        categoryRepository.save(category);
        return category;
    }

    private DetailCategory createDetailCategory(Category category) {
        DetailCategory detailCategory = DetailCategory.builder()
                .id(1)
                .category(category)
                .name("서버")
                .build();
        detailCategoryRepository.save(detailCategory);
        return detailCategory;
    }


}