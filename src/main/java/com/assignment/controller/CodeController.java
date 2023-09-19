package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assignment.service.CodeService;

@RestController
@RequestMapping("/codes")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @PostMapping("/generateAndInsert")
    public ResponseEntity<String> generateAndInsertCodes(@RequestParam("numRows") int numRows) {
        // Generate and insert codes
        codeService.generateAndInsertCodes(numRows);

        return ResponseEntity.ok("Generated and inserted " + numRows + " codes into the database.");
    }
}
