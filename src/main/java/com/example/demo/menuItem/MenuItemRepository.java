package com.example.demo.menuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuItemRepository  extends JpaRepository<MenuItem, Long> {
@Query("SELECT s FROM MenuItem s WHERE s.menuItemId = ?1")
    Optional<MenuItem> findMenuItemById(Long menuItemId);
}