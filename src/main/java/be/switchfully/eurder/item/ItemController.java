package be.switchfully.eurder.item;

import be.switchfully.eurder.item.dto.NewItemDto;
import be.switchfully.eurder.security.Feature;
import be.switchfully.eurder.security.SecurityService;
import be.switchfully.eurder.security.exceptions.LoginException;
import be.switchfully.eurder.security.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("item")
public class ItemController {

    private final ItemService itemService;
    private final SecurityService securityService;

    public ItemController(ItemService itemService, SecurityService securityService) {
        this.itemService = itemService;
        this.securityService = securityService;
    }

    @PostMapping("new")
    public void addNewItem(@RequestHeader(value = "Authorization") String auth,
                           @RequestBody NewItemDto newItemDto){

        System.out.println(auth);
        try {
            securityService.validateAdminAuthorization(auth, Feature.ADD_NEW_ITEM);
        } catch (UnauthorizedException | LoginException exception) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, exception.getMessage(), exception);
        }

        itemService.addNewItem(newItemDto);
    }
}
