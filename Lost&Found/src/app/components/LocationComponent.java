package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import app.dto.LocationDTO;
import app.entities.Location;
import app.repositories.LocationRepository;

@Component
public class LocationComponent {
    @Autowired
    private LocationRepository locationRepository;

    public LocationDTO createLocation(LocationDTO locationDTO) {
        Location location = convertToEntity(locationDTO);
        Location createdLocation = locationRepository.save(location);
        return convertToDTO(createdLocation);
    }

    public Optional<LocationDTO> getLocation(int locationID) {
        return locationRepository.findByLocationID(locationID).map(this::convertToDTO);
    }

    private LocationDTO convertToDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setLocationID(location.getLocationID());
        locationDTO.setLocationName(location.getLocationName());
        locationDTO.setLongitude(location.getLongitude());
        locationDTO.setLatitude(location.getLatitude());
        return locationDTO;
    }

    public Location convertToEntity(LocationDTO locationDTO) {
        Location location = new Location();
        location.setLocationID(locationDTO.getLocationID());
        location.setLocationName(locationDTO.getLocationName());
        location.setLongitude(locationDTO.getLongitude());
        location.setLatitude(locationDTO.getLatitude());
        return location;
    }
}
