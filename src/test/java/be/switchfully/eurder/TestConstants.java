package be.switchfully.eurder;

import be.switchfully.eurder.customer.domain.Address;
import be.switchfully.eurder.customer.domain.Customer;
import be.switchfully.eurder.customer.dto.NewCustomerDto;
import be.switchfully.eurder.item.domain.Item;
import be.switchfully.eurder.item.domain.ItemState;
import be.switchfully.eurder.item.dto.NewItemDto;

import java.math.BigDecimal;

public class TestConstants {

    //------Items--------
    public static final Item ITEM1 = new Item("Item1", "item_description", BigDecimal.ONE, 10, ItemState.PRISTINE);
    public static final NewItemDto ITEM1_DTO = new NewItemDto("Item1", "item_description",BigDecimal.ONE, 10, ItemState.PRISTINE);


    //-------Customers--------
    private static final Address ADDRESS = new Address("België", "Duffel", 2750, "Standplaats", 84);
    public static final NewCustomerDto NEW_CUSTOMER_DTO = new NewCustomerDto("Rob", "siemons", "rsiemons@hotmail.com", "0470123456", "passwoord", ADDRESS);
    public static final NewCustomerDto NEW_CUSTOMER_DTO2 = new NewCustomerDto("Rob2", "siemons2", "rsiemons@hotmail.com", "0470123456", "passwoord", ADDRESS);
    public static final Customer CUSTOMER = new Customer("Rob", "siemons", "rsiemons@hotmail.com", ADDRESS, "passwoord", "passwoord");
    public static final Customer CUSTOMER2 = new Customer("Rob1", "siemons2", "rsiemons@hotmail.com", ADDRESS, "passwoord", "passwoord");
}
