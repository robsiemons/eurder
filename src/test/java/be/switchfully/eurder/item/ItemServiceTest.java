package be.switchfully.eurder.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static be.switchfully.eurder.TestConstants.*;

class ItemServiceTest {
    ItemService itemService;
    ItemMapper mockedItemMapper;
    ItemRepository mockedItemRepository;

    @BeforeEach
    void setUp() {
        mockedItemRepository = Mockito.mock(ItemRepository.class);
        mockedItemMapper = Mockito.mock(ItemMapper.class);
        itemService = new ItemService(mockedItemRepository, mockedItemMapper);
    }

    @Test
    void givenNewItem_whenAddingNewItem_thenItemGetsAdded() {
        //given
        Mockito.when(mockedItemMapper.mapItemDtoToItem(ITEM1_DTO)).thenReturn(ITEM1);
        //When
        itemService.addNewItem(ITEM1_DTO);
        //then

        Mockito.verify(mockedItemRepository).addNewItem(ITEM1);
    }
}