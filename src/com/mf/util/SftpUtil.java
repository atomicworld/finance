package com.mf.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

@Service
public class SftpUtil {  	 
    private String host ;
    private String username;
    private String password;	  
    private String port ;  
	private String bootDir ="";    
    private ChannelSftp sftpObj = null;  
   
    
    private final String dirSeperator = "/";  
      
    public SftpUtil(){
    	try {
    		Properties prop = new Properties();  	
    		InputStream in  = this.getClass().getResourceAsStream("/sms.properties");
    		prop.load(in); 
			host = prop.getProperty("sftp_host");
			username = prop.getProperty("sftp_user");
			password = prop.getProperty("sftp_psw");
			port = prop.getProperty("sftp_port");
			bootDir = prop.getProperty("sftp_dir");
    	}catch(Exception e) {
    		System.out.println(e.toString());
    		
    	}
    } 
    
    /** 
     * connect server via sftp 
     */  
    public void connect() {  
        try {  
            if(sftpObj != null){  
               sftpObj.disconnect();
            }  
            JSch jsch = new JSch();  
            Session sshSession = null;
            if(Integer.parseInt(port) <=0){
                //连接服务器，采用默认端口
            	sshSession = jsch.getSession(username, host);
            }else{
                //采用指定的端口连接服务器
            	sshSession = jsch.getSession(username, host ,Integer.parseInt(port));
            }
            
            if (sshSession == null) {
                throw new Exception("session is null");
            }
             
            //设置登陆主机的密码
            sshSession.setPassword(password);//设置密码   
            //设置第一次登陆的时候提示，可选值：(ask | yes | no)
            sshSession.setConfig("StrictHostKeyChecking", "no");
            //设置登陆超时时间   
            sshSession.connect();            
            //创建sftp通信通道
            Channel channel = sshSession.openChannel("sftp");  
            channel.connect();  
            sftpObj = (ChannelSftp) channel;  
           
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * Disconnect with server 
     */  
    public void disconnect() {  
        if(this.sftpObj != null){  
            if(this.sftpObj.isConnected()){  
                this.sftpObj.disconnect();  
            }
        }    
    }  
    /**
     * 将sftp服务器上的文件下载到本地
     * @param sftpDir ：sftp服务器文件存放的目录
     * @param downloadFile ：下载到本地的文件名
     * @param saveFile:sftp服务器上的文件
     * @param sftp
     */
    public void download(String sftpDir, String downloadFile,String saveFile) {  
        try {  
        	sftpObj.cd(bootDir);
        	sftpObj.cd(sftpDir);  
            File file = new File(saveFile);  
            sftpObj.get(downloadFile, new FileOutputStream(file));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
    /**
     * 将sftp服务器上的文件下载到本地
     * @param sftpDir ：sftp服务器文件存放的目录
     * @param downloadFile ：下载到本地的文件名
     * @param saveFile:sftp服务器上的文件
     * @param sftp
     */
    public void download(String sftpDir, String downloadFile,OutputStream saveFile) {  
        try {  
        	sftpObj.cd(bootDir);
        	sftpObj.cd(sftpDir);              
            sftpObj.get(downloadFile, saveFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     *将本地目录下所有文件上传到sftp服务器上
     * fileListPath  ： 待上传的目录路径
     */  
    public void upload(String childDir,FileInputStream uploadStream,String saveFileName )throws Exception {    
    	createDir(childDir);  
    	this.sftpObj.put(uploadStream, saveFileName);   
    }  
    
    /** 
     * 删除sftp服务器上指定文件
     * fileListPath  ： 待上传的目录路径
     */  
    public void deleteFile(String delDir,String saveFileName ) {    
    	try{ 
	    	sftpObj.cd(bootDir);
	    	sftpObj.cd(delDir);
	    	sftpObj.rm(saveFileName);
    	}catch(SftpException e) {
    		System.out.println("delete ftp file,error message=>" +e.toString());
    	}
    }  
    
    
    /**
     * 判断子目录是否存在，
     * 存在进入子目录，不存在创建子目录
     * @param childDir ：子目录结构【Q0001/20151208/U0001
     * @throws Exception
     */
    private void createDir(String childDir) throws Exception { 
    	sftpObj.cd(bootDir);
        String[] pathList = childDir.split(dirSeperator);
        for(int i=0; i <pathList.length;i++ ) {
        	try {             	
        		//存在就不用进入，不存在创建
        		sftpObj.cd(pathList[i]);
            } catch (SftpException e1) { 
            	sftpObj.mkdir(pathList[i]);
            	sftpObj.cd(pathList[i]);
            }  
        }
    }  
  
    
}  