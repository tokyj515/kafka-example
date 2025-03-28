package com.kt.service;

import com.azure.storage.blob.*;
import com.azure.storage.blob.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class BlobService {

    private final BlobContainerClient blobContainerClient;

    public String uploadFile(MultipartFile file) throws Exception {
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        BlobClient blobClient = blobContainerClient.getBlobClient(fileName);

        try (InputStream inputStream = file.getInputStream()) {
            blobClient.upload(inputStream, file.getSize(), true);
        }

        return blobClient.getBlobUrl(); // 퍼블릭 컨테이너일 경우 외부 접근 가능
    }

}
