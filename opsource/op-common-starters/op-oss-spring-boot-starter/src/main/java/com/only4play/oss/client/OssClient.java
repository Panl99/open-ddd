package com.only4play.oss.client;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import java.io.IOException;
import java.io.InputStream;

/**
 * Oss 基础操作
 * 想要更复杂订单操作可以直接获取AmazonS3，通过AmazonS3 来进行复杂的操作
 * https://docs.aws.amazon.com/zh_cn/sdk-for-java/v1/developer-guide/examples-s3-buckets.html
 */
public interface OssClient{
    /**
     * 创建bucket
     * @param bucketName
     */
    void createBucket(String bucketName);

    /**
     * 获取url
     * @param bucketName
     * @param objectName
     * @return
     */
    String getObjectURL(String bucketName, String objectName);


    /**
     * 获取存储对象信息
     * @param bucketName
     * @param objectName
     * @return
     */
    S3Object getObjectInfo(String bucketName, String objectName);


    /**
     * 上传文件
     * @param bucketName
     * @param objectName
     * @param stream
     * @param size
     * @param contextType
     * @return
     * @throws IOException
     */
    PutObjectResult putObject(String bucketName, String objectName, InputStream stream, long size, String contextType) throws IOException;


    default PutObjectResult putObject(String bucketName, String objectName, InputStream stream) throws IOException{
        return putObject(bucketName,objectName,stream, stream.available(), "application/octet-stream");
    }

    AmazonS3 getS3Client();
}
