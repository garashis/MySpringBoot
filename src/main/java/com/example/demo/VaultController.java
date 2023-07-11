package com.example.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
public class VaultController {
    @Autowired
    private VaultOperations vaultOperations;

    @GetMapping("/encryptWithVault/{data}")
    public String encrypt(@PathVariable String data) {
        log.info("Start encrypt");
        String ciphertextOfData = null;
        try {
            Plaintext plaintext = Plaintext.of(data);
            Ciphertext ciphertext = vaultOperations.opsForTransit().encrypt("sample-key", plaintext);
            ciphertextOfData = ciphertext.getCiphertext();
            log.info("Finished encrypt");
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        log.info("Finish encrypt " + ciphertextOfData);
        decrypt(ciphertextOfData);
        return ciphertextOfData;
    }

    @GetMapping("/decryptWithVault/{ciphertextOfData}")
    public String decrypt(@PathVariable String ciphertextOfData) {
        log.info("Start decrypt");
        String plaintextOfData = null;
        try {
            Ciphertext ciphertext = Ciphertext.of(ciphertextOfData);
            Plaintext plaintext = vaultOperations.opsForTransit().decrypt("sample-key", ciphertext);
            plaintextOfData = plaintext.asString();
            log.info("Finished decrypt");
        } catch (Exception e) {
            log.info("decrypt error : " + e.getMessage());
        }

        log.info("Finish decrypt " + plaintextOfData);
        return plaintextOfData;
    }
}

