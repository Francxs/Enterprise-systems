package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import app.dto.ClaimEventDTO;
import app.entities.ClaimEvent;
import app.entities.Item;
import app.repositories.ClaimEventRepository;
import app.repositories.ItemRepository;

@Component
public class ClaimEventComponent {
    @Autowired
    private ClaimEventRepository claimEventRepository;

    @Autowired
    private ItemRepository itemRepository;

    public ClaimEventDTO createEvent(ClaimEventDTO eventDTO) {
        ClaimEvent event = convertToEntity(eventDTO);
        ClaimEvent createdEvent = claimEventRepository.save(event);
        return convertToDTO(createdEvent);
    }

    public Optional<ClaimEventDTO> getEvent(int claimID) {
        return claimEventRepository.findByClaimID(claimID).map(this::convertToDTO);
    }

    private ClaimEventDTO convertToDTO(ClaimEvent event) {
        ClaimEventDTO eventDTO = new ClaimEventDTO();
        eventDTO.setClaimID(event.getClaimID());
        eventDTO.setItemID(event.getItem().getItemID()); // Correctly get itemID from Item object
        eventDTO.setClaimReport(event.getClaimReport());
        eventDTO.setClaimDate(event.getClaimDate());
        eventDTO.setClaimantName(event.getClaimantName());
        eventDTO.setClaimantContact(event.getClaimantContact());
        return eventDTO;
    }

    public ClaimEvent convertToEntity(ClaimEventDTO eventDTO) {
        ClaimEvent event = new ClaimEvent();
        event.setClaimID(eventDTO.getClaimID());
        
        // Fetch the Item entity using itemID from the DTO
        Item item = itemRepository.findByItemID(eventDTO.getItemID())
                                  .orElseThrow(() -> new RuntimeException("Item not found"));
        event.setItem(item); // Correctly set Item object

        event.setClaimReport(eventDTO.getClaimReport());
        event.setClaimDate(eventDTO.getClaimDate());
        event.setClaimantName(eventDTO.getClaimantName());
        event.setClaimantContact(eventDTO.getClaimantContact());
        return event;
    }
}
