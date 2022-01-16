package com.example.demo.menuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MenuItemService {
    public final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }
    public List<MenuItem> getMenuItems() {
        return menuItemRepository.findAll();
    }
    public void addNewMenuItem(MenuItem menuItem){
        Optional<MenuItem> menuItemOptional = menuItemRepository
                .findMenuItemById(menuItem.getMenuItemId());
        if (menuItemOptional.isPresent()){
            throw new IllegalStateException("Item already exist");
        }
        menuItemRepository.save(menuItem);
    }
    public void deleteMenuItem(Long menuItemId){
        boolean exists = menuItemRepository.existsById(menuItemId);
        if (!exists) {
            throw new IllegalStateException(
                    "MenuItem with id " + menuItemId + " does not exists");
        }
        menuItemRepository.deleteById(menuItemId);
    }

    @Transactional
    public void updateMenuItem(Long menuItemId,
                               String name,
                               String info,
                               String imageUrl,
                               Double price){
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new IllegalStateException(
                        "MenuItem with id " + menuItemId + " does not exist"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(menuItem.getName(), name)){
            menuItem.setName(name);

            menuItem.setInfo(info);
            menuItem.setImageUrl(imageUrl);
            menuItem.setPrice(price);
        }
    }
}