package com.ideabobo.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;








import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.ideabobo.model.Pdt;
import com.ideabobo.service.PdtService;
import com.ideabobo.util.GetNowTime;
import com.ideabobo.util.IdeaAction;
import com.ideabobo.util.Page;

@Controller
public class PdtAction extends IdeaAction {
	@Resource
	private PdtService pdtService;
	private static final long serialVersionUID = -3218238026025256103L;
	private Pdt pdt;
	public Pdt getPdt() {
		return pdt;
	}

	public void setPdt(Pdt pdt) {
		this.pdt = pdt;
	}

	public String pdt(){
		return SUCCESS;
	}
	
	/*******************************上传相关属性************************/
	private File img;
	private String imgFileName;
	
	
	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

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
		String fileName =  UUID.randomUUID()+imgFileName.substring(imgFileName.lastIndexOf("."),imgFileName.length());
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
	public void getList(){
		String objname = request.getParameter("stitle");
		String type = request.getParameter("type");
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		Page page = new Page();
		Map paramsMap = new HashMap();
		paramsMap.put("objname", objname);
		paramsMap.put("type", type);
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
		page = pdtService.findByPage(page, paramsMap);
		Gson json = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", page.getTotal());
		map.put("rows", page.getList());
		render(json.toJson(map));		
	}
	
	
	public void add(){
		String action = request.getParameter("action");
		if(pdt != null){
			if(img != null){
				String filename = upload();
			}
			pdt.setType(2);
			if(action.equals("add")){
				pdtService.save(pdt);
				render("操作成功!");
			}else {
				String id = request.getParameter("id");
				pdt.setId(Integer.parseInt(id));
				pdtService.update(pdt);
				render("操作成功!");
			}
		}		
	}
	
	public void deleteItem(){
		String id = request.getParameter("id");
		pdtService.delete(Integer.parseInt(id));
		render("操作成功");
	}
	

}
