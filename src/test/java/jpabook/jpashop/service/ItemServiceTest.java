package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Test
    public void 전체조회() throws Exception {
        Album album1 = new Album();
        Album album2 = new Album();
        album1.setArtist("kim1");
        album2.setArtist("kim2");

        itemService.saveItem(album1);
        itemService.saveItem(album2);
        List<Item> result = itemService.findItems();

        assertThat(result.size()).isEqualTo(2);
    }
}