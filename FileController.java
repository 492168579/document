package com.rms.ypzw.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.rms.framework.base.BaseController;
import com.rms.framework.exception.AppException;
import com.rms.framework.exception.SysException;
import com.rms.system.security.SecurityManager;
import com.rms.ypzw.delegate.IWoIssueDelegate;
import com.rms.ypzw.entity.WoAttachment;
import com.rms.ypzw.entity.WoIssue;
import com.rms.ypzw.service.IWoAttachmentService;


@RequestMapping("/powergrid/problemwork/my")
public class FileController  {
	
    @Autowired
    private IWoIssueDelegate woIssueDelegate;
    
    @Autowired
    private IWoAttachmentService woAttachmentService;
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    @CrossOrigin
    public Object getFile(HttpServletRequest request){
    	String uploadDir="D:\\test\\";
    	String woIssueId= request.getParameter("woid");//获取非文件的属性值方法
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        if(fileMap == null || fileMap.size() == 0){
        	
            return "not success";
        }
        Collection<MultipartFile> files = fileMap.values();
        for(MultipartFile file:files){
            //注意这里获取的个数，是根据前端form表单里有几个，type=file来决定的，
            // 比如你虽然只点选了一个文件，上传，但这里实际上回有两个MultipartFile对 象，只不过其中一个MutipartFile的文件名会为空，这就是为什么下边会有个判断文件名
            //为空的步骤
            String req= file.getOriginalFilename();
            if(StringUtils.isBlank(req)){
                continue;
            }
            File tempFile = getTmpFile(req,uploadDir);
            System.out.println(tempFile.getAbsolutePath());
            if(!tempFile.exists()){
                tempFile.getParentFile().mkdirs();
                try {
                    tempFile.createNewFile();
                    file.transferTo(tempFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(req);
        }
        return null;
    }
    /**
     * 下边这个是好方法，希望各位能用起来，虽然是个小方法，但我其实真不舍得贴出来，是JAVA自带的方法
     * @param fileName
     * @param dir
     * @return
     */
    public File getTmpFile(String fileName,String dir) {
        //File tmpDir = FileUtils.getTempDirectory();
        //System.out.println("========"+tmpDir.getAbsolutePath());
        //String tmpFileName = (Math.random() * 10000 + "").replace(".", "")+"_"+fileName;
        return new File(dir, fileName);
    }

	
	
	
	
	
	}
	
	


