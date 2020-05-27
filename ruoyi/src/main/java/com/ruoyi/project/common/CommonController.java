package com.ruoyi.project.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qiniu.util.Auth;
import com.ruoyi.common.utils.ByFileUtil;
import com.ruoyi.framework.config.FileConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.web.domain.AjaxResult;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static com.ruoyi.common.utils.file.FileUploadUtils.extractFilename;

/**
 * 通用请求处理
 *
 * @author ruoyi
 */
@RestController
public class CommonController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;
    @Resource
    private FileConfig fileConfig;
    @Autowired
    private  FileConfig constantQiniu;

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     */
    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        try {
            if (!FileUtils.isValidFilename(fileName)) {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = RuoYiConfig.getDownloadPath() + fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtils.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    public AjaxResult uploadFile(MultipartFile file) throws Exception {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            System.out.println("path=" + filePath);
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/common/uploadqiniu")
    public AjaxResult uploadFileQiNiu(MultipartFile file) throws Exception {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            //String fileName =FileUploadUtils.upload(filePath, file);

            String fileName = "video" + extractFilename(file);
            System.out.println("start===filename=" + fileName);

            InputStream in = file.getInputStream();
            String url = ByFileUtil.uploadQNImg(in, fileName, fileConfig);

            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            System.out.println("end===");
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 获取七牛token
     **/
    @PostMapping("/common/getQiNiuToken")
    public AjaxResult getQiNiuToken() {
        AjaxResult ajax = AjaxResult.success();

        Auth auth = Auth.create(constantQiniu.getAccessKey(), constantQiniu.getSecretKey());
        System.out.println("auth:" + auth);
        String upToken = auth.uploadToken(constantQiniu.getBucket());
        ajax.put("token", upToken);
        return ajax;
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String name, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 本地资源路径
        String localPath = RuoYiConfig.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + StringUtils.substringAfter(name, Constants.RESOURCE_PREFIX);
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }
}
