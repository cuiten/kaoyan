package com.ideabobo.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.ideabobo.model.Video;
import com.ideabobo.model.Type;
import com.ideabobo.service.VideoService;
import com.ideabobo.service.TypeService;
import com.ideabobo.util.GetNowTime;
import com.ideabobo.util.IdeaAction;
import com.ideabobo.util.Page;

@Controller
public class VideoAction extends IdeaAction {
	@Resource
	private VideoService videoService;
	@Resource
	private TypeService typeService;
	private static final long serialVersionUID = -3218238026025256103L;
	private Video video;
	private Type type;
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public String video(){
		return SUCCESS;
	}

    public String videoshop(){
        return "videoshop";
    }
	
	public String type(){
		return "type";
	}
	
	/*******************************上传相关属性************************/
	private File img;
	private String imgFileName;
	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String upload(){
		System.out.println("开始上传.......");
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, 32);
		String fileName = uuid+".gif";
		FileOutputStream fos=null;
	    FileInputStream fis=null;
	    //int size = 0;
	    String uploadPath = ServletActionContext.getServletContext().getRealPath("upload");
	    String path=uploadPath+ File.separator+fileName;
	    //String type =uploadFileName.substring(uploadFileName.lastIndexOf(".")+1);
	    File file = new File(uploadPath);
	    if (!file.exists()){
	    	file.mkdirs();
	    }
	    try {
			fos=new FileOutputStream(path);
			fis=new FileInputStream(img);
			//size = fis.available();
			byte[] buf=new byte[10240];
	    	int len=-1;
	    	while((len=fis.read(buf))!=-1){
	    		fos.write(buf, 0, len);
	    	}
	    	fos.flush();
	    	//PrintWriter out = ServletActionContext.getResponse().getWriter();
	    	return fileName;
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/*******************************上传相关属性************************/
	/*******************************上传相关属性************************/
	private File vimg;
	private String vimgFileName;
	public File getVimg() {
		return vimg;
	}

	public void setVimg(File vimg) {
		this.vimg = vimg;
	}

	public String uploadVideo(){
		System.out.println("开始上传.......");
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, 32);
		String fileName = uuid+".mp4";
		FileOutputStream fos=null;
	    FileInputStream fis=null;
	    //int size = 0;
	    String uploadPath = ServletActionContext.getServletContext().getRealPath("upload");
	    String path=uploadPath+ File.separator+fileName;
	    //String type =uploadFileName.substring(uploadFileName.lastIndexOf(".")+1);
	    File file = new File(uploadPath);
	    if (!file.exists()){
	    	file.mkdirs();
	    }
	    try {
			fos=new FileOutputStream(path);
			fis=new FileInputStream(vimg);
			//size = fis.available();
			byte[] buf=new byte[10240];
	    	int len=-1;
	    	while((len=fis.read(buf))!=-1){
	    		fos.write(buf, 0, len);
	    	}
	    	fos.flush();
	    	//PrintWriter out = ServletActionContext.getResponse().getWriter();
	    	return fileName;
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/*******************************上传相关属性************************/
	public void getList(){
		String videoname = request.getParameter("sgname");
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		Page page = new Page();
		Map paramsMap = new HashMap();
		paramsMap.put("videoname", videoname);
		paramsMap.put("sort", "order by "+sort+" "+order);
        String roletype = (String) session.get("roletype");
        if(roletype.equals("3")){
            String sid = (String) session.get("sid");
            paramsMap.put("sid",sid);
        }
		String pageNo = (String) this.request.getParameter("page");
		String pageSizes = (String) this.request.getParameter("rows");
		if (pageNo == null) {
			page.setPageSize(10);
			page.setPageNo(1);
		} else {
			page.setPageSize(Integer.parseInt(pageSizes));
			page.setPageNo(Integer.parseInt(pageNo));
		}
		page = videoService.findByPage(page, paramsMap);
		Gson json = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", page.getTotal());
		map.put("rows", page.getList());
		render(json.toJson(map));		
	}
	
	public void getTypeList(){
		String typename = request.getParameter("stype");
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		Page page = new Page();
		Map paramsMap = new HashMap();
		paramsMap.put("typename", typename);
		paramsMap.put("sort", "order by "+sort+" "+order);
		String pageNo = (String) this.request.getParameter("page");
		String pageSizes = (String) this.request.getParameter("rows");
		if (pageNo == null) {
			page.setPageSize(10);
			page.setPageNo(1);
		} else {
			page.setPageSize(Integer.parseInt(pageSizes));
			page.setPageNo(Integer.parseInt(pageNo));
		}
		page = typeService.findByPage(page, paramsMap);
		Gson json = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", page.getTotal());
		map.put("rows", page.getList());
		render(json.toJson(map));		
	}
	
	public void typeList(){
		ArrayList<Type> list = (ArrayList<Type>) typeService.list();
		Gson json = new Gson();
		render(json.toJson(list));
	}
	
	public void add(){
		String action = request.getParameter("action");
		if(video != null){
		
			if(img != null){
				String filename = upload();
				video.setImg(filename);
			}
			if(vimg != null){
				String filename = uploadVideo();
				video.setVideo(filename);
			}
			if(action.equals("add")){
				videoService.save(video);
				render("操作成功!");
			}else {
				String id = request.getParameter("id");
				video.setId(Integer.parseInt(id));
				videoService.update(video);
				render("操作成功!");
			}
		}		
	}
	
	public void addType(){
		String action = request.getParameter("action");
		if(type != null){
			if(action.equals("add")){
				typeService.save(type);
				render("操作成功!");
			}else {
				String id = request.getParameter("id");
				type.setId(Integer.parseInt(id));
				typeService.update(type);
				render("操作成功!");
			}
		}		
	}
	
	
	
	public void deleteItem(){
		String id = request.getParameter("id");
		videoService.delete(Integer.parseInt(id));
		render("操作成功");
	}
	
	public void deleteTypeItem(){
		String id = request.getParameter("id");
		typeService.delete(Integer.parseInt(id));
		render("操作成功");
	}
	

		
}
