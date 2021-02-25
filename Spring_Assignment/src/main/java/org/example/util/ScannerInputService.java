package org.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("scannerInputService")
public class ScannerInputService implements UserInputService{

    ScannerConfiguration  scannerConfiguration;

    @Autowired
    public void setScannerConfiguration(ScannerConfiguration scannerConfiguration) {
        this.scannerConfiguration = scannerConfiguration;
    }

    @Override
    public String getString() {
        return "String from Scanner input service";
    }

    @Override
    public int getInt() {
        return 1;
    }
}
