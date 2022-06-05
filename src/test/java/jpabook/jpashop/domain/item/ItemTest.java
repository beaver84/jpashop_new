package jpabook.jpashop.domain.item;

import jpabook.jpashop.exception.NotEnoughStockException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ItemTest {

    @Test
    public void 수량증가() {
        //given
        Item item = new Book();
        item.setStockQuantity(10);

        //when
        item.addStock(10);

        //Then
        Assertions.assertThat(item.getStockQuantity()).isEqualTo(20);
    }

    @Test
    public void 수량감소_합계0_이상() {
        //given
        Item item = new Book();
        item.setStockQuantity(10);

        //when
        try {
            item.removeStock(10);
        } catch (NotEnoughStockException e) {
            return;
        }

        //Then
        Assertions.assertThat(item.getStockQuantity()).isEqualTo(0);

    }

    @Test
    public void 수량감소_예외발생() {
        //given
        Item item = new Book();
        item.setStockQuantity(10);

        //when
        try {
            item.removeStock(11);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        fail("예외가 발생해야 한다.");
    }

}
