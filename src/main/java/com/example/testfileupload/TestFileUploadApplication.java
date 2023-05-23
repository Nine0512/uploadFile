package com.example.testfileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.example.testfileupload.properties.FileStoreProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStoreProperties.class
})
public class TestFileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestFileUploadApplication.class, args);
    }

}
