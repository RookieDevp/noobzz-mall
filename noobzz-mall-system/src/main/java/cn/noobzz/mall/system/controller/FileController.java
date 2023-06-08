package cn.noobzz.mall.system.controller;

import cn.noobzz.mall.core.base.Result;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author: ZZJ
 * @date: 2023/06/08
 * @desc:
 */
@RestController
public class FileController {

    @Autowired
    private MinioClient minioClient;

    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        // 上传文件到 MinIO
        ObjectWriteResponse response = minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket("public")
                        .object(file.getOriginalFilename())
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .build());
        return Result.success("上传成功！");
    }

    @GetMapping("/download/{fileName}")
    @ApiOperation(value = "文件下载")
    public ResponseEntity<InputStreamResource> download(@PathVariable String fileName) throws Exception {
        // 获取 MinIO 上的文件流
        InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket("public")
                        .object(fileName)
                        .build());

        // 构造 ResponseEntity 对象，返回文件流给浏览器下载
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(new InputStreamResource(stream));
    }
}

