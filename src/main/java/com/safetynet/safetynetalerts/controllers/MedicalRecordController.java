package com.safetynet.safetynetalerts.controllers;

import com.safetynet.safetynetalerts.dtos.MedicalRecordDTO;
import com.safetynet.safetynetalerts.domain.MedicalRecord;
import com.safetynet.safetynetalerts.service.MedicalRecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Yahia CHERIFI
 * this controller is responsible for.
 * CRUD operations on MedicalRecord
 */

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

    /**
     * medicalRecordService.
     * @see MedicalRecordService
     */
    private final MedicalRecordService medicalRecordService;

    /**
     * MedicalRecordController logger.
     */
    private static final Logger LOGGER = LogManager
            .getLogger(MedicalRecordController.class);

    /**
     * Used in logging messages.
     * Data provided by users will be changed
     * some characters will omitted for security purposes:
     * Logging injection
     */
    private static final String DANGEROUS_CHARACTERS =  "[\n\r\t]";

    /**
     * DANGEROUS_CHARACTERS will be replaced by REPLACEMENT_CHARACTER.
     */
    private static final String REPLACEMENT_CHARACTER = "_";

    /**
     * Constructor injection.
     * @param service medicalRecordService
     */
    @Autowired
    public MedicalRecordController(
            final MedicalRecordService service) {
        this.medicalRecordService = service;
    }

    /**
     * Get request.
     * retrieves all the medical records
     * @return a list of MedicalRecordDTO
     */
    @GetMapping("/records")
    public List<MedicalRecordDTO> findAllMedicalRecords() {
        LOGGER.debug("Get request sent from the MedicalRecordController");
        return medicalRecordService.findAll();
    }

    /**
     * Post request.
     * save a new medical record
     * @param medicalRecord medical record to save
     * @return the saved medical record
     */
    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MedicalRecord addMedicalRecord(
            @RequestBody final MedicalRecord medicalRecord) {
        LOGGER.debug("Post request sent from the MedicalRecordController");
        medicalRecordService.save(medicalRecord);
        return medicalRecord;
    }

    /**
     * Put request.
     * updated an existing medical record
     * @param medicalRecord medical record to update
     * @return the updated medical record
     */
    @PutMapping("/update")
    public MedicalRecord updateMedicalRecord(
            @RequestBody final MedicalRecord medicalRecord) {
        LOGGER.debug("Put request sent from the MedicalRecordController");
        medicalRecordService.save(medicalRecord);
        return medicalRecord;
    }

    /**
     * Delete request.
     * delete an existing medical record by first name and last name
     * @param firstName a person's first name
     * @param lastName a person's last name
     * @return a message if the medical recorded deleted successfully
     * throw an exception if no medical record had been deleted
     */
    @DeleteMapping("/delete/{firstName}&{lastName}")
    public String deleteMedicalRecord(
            @PathVariable final String firstName,
            @PathVariable final String lastName) {
        String secureFirstNameCharacters = firstName
                .replaceAll(DANGEROUS_CHARACTERS, REPLACEMENT_CHARACTER);
        String secureLastNameCharacters = lastName
                .replaceAll(DANGEROUS_CHARACTERS, REPLACEMENT_CHARACTER);
        LOGGER.debug("Delete request sent from the MedicalRecordController");
        medicalRecordService.deleteByFirstNameAndLastName(firstName, lastName);
        return ("Medical records for '" + secureFirstNameCharacters + " "
                + secureLastNameCharacters + "' were deleted successfully");
    }
}
