/**
 * Copyright © 2018 eSunny Info. Developer Stu. All rights reserved.
 *
 * @Package:
 * @author: zpx
 * Build File @date: 2018/8/27 21:38
 * @Description TODO
 * @version 1.0
 */
package com.smxy.recipe.utils;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class FastDFSClient {
    private static final Logger logger = LoggerFactory.getLogger(FastDFSClient.class);
    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private static StorageClient1 storageClient;
    private static StorageServer storageServer;
    static {
        try {
            String filePath = new ClassPathResource("fastdfs_server.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient = new StorageClient1(trackerServer, storageServer);
        } catch (Exception e) {
            logger.error("FastDFS Client Init Fail!",e);
        }
    }
    public static String upload_file(String fileName, String ext_name, NameValuePair[] pairs) throws Exception{
        return storageClient.upload_file1(fileName, ext_name, pairs);
    }

    public static int delete_file(String fileName) throws Exception {
        return storageClient.delete_file1(fileName);
    }

    public static String upload_binary_file(byte[] source, String ext_name, NameValuePair[] pairs) throws Exception{
        return storageClient.upload_file1(source, ext_name, pairs);
    }

}
