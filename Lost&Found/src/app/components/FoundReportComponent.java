package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import app.dto.FoundReportDTO;
//import app.dto.LocationDTO;
import app.entities.ClaimEvent;
import app.entities.FoundReport;
import app.entities.Location;
import app.entities.User;
import app.repositories.ClaimEventRepository;
import app.repositories.FoundReportRepository;
import app.repositories.LocationRepository;
import app.repositories.UserRepository;

@Component
public class FoundReportComponent {
    @Autowired
    private FoundReportRepository foundReportRepository;

    @Autowired
    private ClaimEventRepository claimEventRepository;

    @Autowired
//    private LocationComponent locationComponent;
    private LocationRepository locationRepository;

    @Autowired
    private UserRepository userRepository;

    public FoundReportDTO createReport(FoundReportDTO reportDTO) {
        FoundReport report = convertToEntity(reportDTO);
        FoundReport createdReport = foundReportRepository.save(report);
        return convertToDTO(createdReport);
    }

    public Optional<FoundReportDTO> getReport(int foundID) {
        return foundReportRepository.findByFoundID(foundID).map(this::convertToDTO);
    }

    private FoundReportDTO convertToDTO(FoundReport report) {
        FoundReportDTO reportDTO = new FoundReportDTO();
        reportDTO.setFoundID(report.getFoundID());
        reportDTO.setClaimID(report.getClaimEvent().getClaimID());
        reportDTO.setFoundDate(report.getFoundDate());
        reportDTO.setLocationID(report.getLocation().getLocationID());
        reportDTO.setFoundDetails(report.getFoundDetails());
        reportDTO.setIdNumber(report.getUser().getIDNumber());
        return reportDTO;
    }

    private FoundReport convertToEntity(FoundReportDTO reportDTO) {
        FoundReport report = new FoundReport();
        report.setFoundID(reportDTO.getFoundID());

        
        ClaimEvent claimEvent = claimEventRepository.findByClaimID(reportDTO.getClaimID())
                                  .orElseThrow(() -> new RuntimeException("ClaimEvent not found"));
        report.setClaimEvent(claimEvent);
        report.setFoundDate(reportDTO.getFoundDate());
        

        Location location = locationRepository.findByLocationID(reportDTO.getLocationID())
                                .orElseThrow(() -> new RuntimeException("Location not found"));
        report.setLocation(location); 
        report.setFoundDetails(reportDTO.getFoundDetails());
        
        
        User user = userRepository.findByIdNumber(reportDTO.getIdNumber())
                                  .orElseThrow(() -> new RuntimeException("User not found"));      
        report.setUser(user);
        
        
        return report;
    }
}