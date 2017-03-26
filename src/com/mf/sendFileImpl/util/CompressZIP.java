package com.mf.sendFileImpl.util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import com.mf.sendFileImpl.entity.MyFile;

public class CompressZIP {
	
	public static void packXML(String str, String filename, String zipFile){
		try{
			ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));	//声明ZipOutputStream，用来输出zip文件.
			
			ZipEntry entry = new ZipEntry(filename);	//声明ZipEntry
			zipOut.putNextEntry(entry);	//将entry加入到zipOut中。
			DataOutputStream dataOut = new DataOutputStream(zipOut);	//利用DataOutputStream对ZipOutputStream进行包装。
			dataOut.writeChars(str.toString());	//输出zip文件
			dataOut.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @param list	带文件信息和文件名的 list
	 * @param zipFile	目标文件名称
	 */
	public static void compress(List<MyFile> list, String zipFile, String dest){
		try{
			//当文件夹不存在，新建
			if ( !(new File(dest)).isDirectory() ) {
				new File(dest).mkdir();
			}
			CheckedOutputStream check = new CheckedOutputStream (new FileOutputStream(zipFile), new Adler32());
			ZipOutputStream zipOut = new ZipOutputStream(check);	//声明ZipOutputStream，用来输出zip文件.
			DataOutputStream out = new DataOutputStream(zipOut);	//利用DataOutputStream对ZipOutputStream进行包装。
			for (MyFile test : list){
				ZipEntry entry = new ZipEntry( test.getFilename() );	//声明ZipEntry
				zipOut.putNextEntry(entry);								//将entry加入到zipOut中。
			    out.writeChars(test.getContent().toString());			//输出zip文件
			}
			out.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
