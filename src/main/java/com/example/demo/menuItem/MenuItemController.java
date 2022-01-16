package com.example.demo.menuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/menuItems")
public class MenuItemController {
    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }
    @GetMapping
    public List<MenuItem> getMenuItems(){

        return menuItemService.getMenuItems();
    }

    @PostMapping
    public void uploadNewMenuItem(@RequestBody MenuItem menuItem){
        menuItemService.addNewMenuItem(menuItem);
    }
    @DeleteMapping(path = "{menuItemId}")
    public void deleteMenuItem(
            @PathVariable("menuItemId") Long menuItemId){
        menuItemService.deleteMenuItem(menuItemId);
    }

    @PutMapping(path = "{menuItemId}")
    public void updateMenuItem(
            @PathVariable("menuItemId") Long menuItemId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String info,
            @RequestParam(required = false) String imageUrl,
            @RequestParam(required = false) Double price){
        menuItemService.updateMenuItem(menuItemId, name, info, imageUrl, price);
    }
}