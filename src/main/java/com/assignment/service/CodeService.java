package com.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.dao.CodeRepository;
import com.assignment.model.Code;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class CodeService {

    @Autowired
    private CodeRepository codeRepository;

    @Transactional
    public void generateAndInsertCodes(int numRows) {
        Set<String> generatedCodes = new HashSet<>();
        Random random = new Random();

        // Generate unique random alphanumeric codes
        while (generatedCodes.size() < numRows) {
            StringBuilder codeBuilder = new StringBuilder();
            for (int i = 0; i < 7; i++) {
                char randomChar = (char) (random.nextInt(26) + 'A');
                codeBuilder.append(randomChar);
            }
            generatedCodes.add(codeBuilder.toString());
        }

        // Insert codes into the database
        for (String code : generatedCodes) {
            Code codeEntity = new Code();
            codeEntity.setCode(code);
            codeRepository.save(codeEntity);
        }
    }
}

