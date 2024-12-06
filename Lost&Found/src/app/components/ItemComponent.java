package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import app.dto.ItemDTO;
import app.entities.Item;
import app.repositories.ItemRepository;

@Component
public class ItemComponent {
    @Autowired
    private ItemRepository itemRepository;

    public ItemDTO createItem(ItemDTO itemDTO) {
        Item item = convertToEntity(itemDTO);
        Item createdItem = itemRepository.save(item);
        return convertToDTO(createdItem);
    }

    public Optional<ItemDTO> getItem(int itemID) {
        return itemRepository.findByItemID(itemID).map(this::convertToDTO);
    }

    private ItemDTO convertToDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemID(item.getItemID());
        itemDTO.setItemCategory(item.getItemCategory());
        itemDTO.setBrand(item.getBrand());
        itemDTO.setModel(item.getModel());
        itemDTO.setColor(item.getColor());
        itemDTO.setSize(item.getSize());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setImage(item.getImage());
        return itemDTO;
    }

    private Item convertToEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setItemID(itemDTO.getItemID());
        item.setItemCategory(itemDTO.getItemCategory());
        item.setBrand(itemDTO.getBrand());
        item.setModel(itemDTO.getModel());
        item.setColor(itemDTO.getColor());
        item.setSize(itemDTO.getSize());
        item.setDescription(itemDTO.getDescription());
        item.setImage(itemDTO.getImage());
        return item;
    }
}