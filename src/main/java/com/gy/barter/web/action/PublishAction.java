package com.gy.barter.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gy.barter.model.Citys;
import com.gy.barter.service.PublishService;
import com.gy.barter.vo.ThingsVO;
import com.gy.barter.vo.UserVO;
import com.opensymphony.xwork2.ActionSupport;

@Controller("publishAction")
public class PublishAction extends ActionSupport{

    @Autowired
    private PublishService publishService;
    
    private ThingsVO thingsVO;
    
    private UserVO userVO;
    
    private String images;
    
    private String district;
    
    private String street;
    
    private List<Citys> towCityList;
    
    private File file;
    private String fileFileName;
    private String fileContentType;
    
    private String message;
	
	private String jsonCity;

	
    public String publish() {
    	//message = " guoyang hellow";
    	towCityList = publishService.getTowCateById("1");
    	
    	System.out.println(towCityList);
    	
    	System.out.println(towCityList.size());
    	
    	jsonCity = publishService.getCategoryJson(towCityList, "1");
    	
    	//HttpSession session = org.apache.struts2.ServletActionContext.getRequest().getSession();
    	//session.setAttribute("gy","asdfasdfasdf");
    	
    	//session.setAttribute("towCityList",towCityList);

		return SUCCESS;
	}
    
    public String toPublish() {
    	//message = " guoyang hellow";

    	System.out.println(thingsVO.getHave());
    	
    	System.out.println(userVO.getUser_name());
    	
    	System.out.println(district);
    	
    	System.out.println(street);
    	
    	System.out.println(images);




		return SUCCESS;
	}
    
    public String upload() {
    	// 实现上传
    	try{
	    	InputStream is = new FileInputStream(file);
	    	String root = ServletActionContext.getRequest().getRealPath("upload");
	    	System.out.println("kk:"+root);
	    	
	    	 UUID uuid  =  UUID.randomUUID();
	    	 System.out.println(uuid.toString());
	    	 
	    	 Date date = new Date();
	    	 SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	    	 String strResponseDate = format.format(date);
	    	 System.out.println(strResponseDate);
	    	
	    	File deskFile = new File("G:/cms5workspace/bartering/target/bartering-1.0-SNAPSHOT/upload", this.getFileFileName());
	    	OutputStream os = new FileOutputStream(deskFile);
	    	byte[] bytefer = new byte[1024];
	    	int length = 0;
	    	while ((length = is.read(bytefer)) != -1) {
	    		os.write(bytefer, 0, length);
	    	}
	    	os.close();
	    	is.close();
    	
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	
    	message = this.getFileFileName();
    	System.out.println("GGG:"+message);
    	return "message";
    }

    
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public List<Citys> getTowCityList() {
		return towCityList;
	}

	public void setTowCityList(List<Citys> towCityList) {
		this.towCityList = towCityList;
	}

	   
	public String getMessage() {
	       return message;        
	}

	public String getJsonCity() {
		return jsonCity;
	}

	public void setJsonCity(String jsonCity) {
		this.jsonCity = jsonCity;
	}

	public ThingsVO getThingsVO() {
		return thingsVO;
	}

	public void setThingsVO(ThingsVO thingsVO) {
		this.thingsVO = thingsVO;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	
    
}
