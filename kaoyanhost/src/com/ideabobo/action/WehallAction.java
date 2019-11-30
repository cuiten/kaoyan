package com.ideabobo.action;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.*;

import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ideabobo.model.Address;
import com.ideabobo.model.Bill;
import com.ideabobo.model.Choose;
import com.ideabobo.model.Dingzuo;
import com.ideabobo.model.Good;
import com.ideabobo.model.Line;
import com.ideabobo.model.Notice;
import com.ideabobo.model.Posts;
import com.ideabobo.model.Replay;
import com.ideabobo.model.Rizhi;
import com.ideabobo.model.Shijuan;
import com.ideabobo.model.Shop;
import com.ideabobo.model.Tousu;
import com.ideabobo.model.User;
import com.ideabobo.service.BaseService;
import com.ideabobo.service.BillService;
import com.ideabobo.service.DingzuoService;
import com.ideabobo.service.GoodService;
import com.ideabobo.service.NoticeService;
import com.ideabobo.service.ReplayService;
import com.ideabobo.service.RoomService;
import com.ideabobo.service.ShopService;
import com.ideabobo.service.TypeService;
import com.ideabobo.service.UserService;
import com.ideabobo.util.GetNowTime;
import com.ideabobo.util.HttpClientTools;
import com.ideabobo.util.IdeaAction;
import com.ideabobo.util.getui.Getui;

@Controller
public class WehallAction extends IdeaAction {
    @Resource
    private BaseService baseService;
    @Resource
    private BillService billService;
    @Resource
    private ShopService shopService;
    @Resource
    private GoodService goodService;
    @Resource
    private DingzuoService dingzuoService;
    @Resource
    private TypeService typeService;
    @Resource
    private UserService userService;
    @Resource
    private ReplayService replayService;
    @Resource
    private NoticeService noticeService;
    @Resource
    private RoomService roomService;
    public Gson gson = new Gson();
    private static final long serialVersionUID = -3218238026025256103L;

    public String wehall(){
//		String openid = request.getParameter("openid");
//		session.put("openid", openid);
        return SUCCESS;
    }

    public void login(){
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        User user = new User();
        user.setPasswd(passwd);
        user.setUsername(encodeGet(username));
        User r = userService.find(user);
        if(r!=null){
        	session.put("user", r);
            renderJsonpObj(r);
        }else{
            renderJsonpString("fail");
        }
    }
    
    public void checkSession(){
    	Object obj = session.get("user");
    	if(obj!=null){
    		renderJsonpObj(obj);
    	}else{
    		renderJsonpString("fail");
    	}
    }
    
    public void clearSession(){
    	session.clear();
    }

    public void checkUser(){
        User u = new User();
        String username = request.getParameter("username");
        u.setUsername(username);
        User r = userService.find(u);
        if(r!=null){
            renderJsonpString("fail");
        }else{
            renderJsonpString("success");
        }
    }

    public void updateUser(){
        String tel = request.getParameter("tel");
        String qq = request.getParameter("qq");
        String wechat = request.getParameter("wechat");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String sex = request.getParameter("sex");
        String img = request.getParameter("img");
        String id = request.getParameter("id");

        User user = userService.find(id);

        user.setId(Integer.parseInt(id));
        user.setTel(tel);
        user.setWechat(wechat);
        user.setQq(qq);
        user.setEmail(email);
        user.setBirth(birth);
        user.setSex(encodeGet(sex));
        user.setImg(img);
        user.setAddress(encodeGet(request.getParameter("address")));

        userService.update(user);
        renderJsonpObj(user);
    }

    public void changePasswd(){
        String passwd = request.getParameter("passwd");
        String id = request.getParameter("id");
        User user = userService.find(id);
        user.setPasswd(passwd);
        userService.update(user);
        renderJsonpString("success");
    }

    public void register(){
    	User user = (User) getByRequest(new User(), true);

        String roletype = "2";

        user.setRoletype(roletype);
  
        //user.setSid(sid);
        userService.save(user);

        renderJsonpString("success");
    }

    public void listShop(){
        renderJsonpObj(shopService.list());
    }
    public void listGood(){
    	String dtype = request.getParameter("dtype");
    	String temp = request.getParameter("temp");
        String type = request.getParameter("stype");
        String sid = request.getParameter("sid");
        String title = request.getParameter("stitle");
        String sort = request.getParameter("order");
        title = encodeGet(title);
        String hql = "from Good t where 1=1";
        if (type != null&& !"".equals(type)) {
            hql+=" and t.typeid="+type;

        }
        if(sid != null&& !"".equals(sid)){
            hql+=" and t.sid="+sid;
        }
        if(title != null&& !"".equals(title)){
            hql+=" and t.gname='"+title+"'";
        }
        if(dtype != null&& !"".equals(dtype)){
            hql+=" and t.dtype="+dtype;
        }
        if(temp != null&& !"".equals(temp)){
            hql+=" and t.tempf<"+temp+" and t.tempt>"+temp;
        }
        if(sort != null&& !"".equals(sort)){
            hql+=" order by "+sort+" desc";
        }else{
        	hql+=" order by xiaoliang desc";
        }
        /*ArrayList<Good> list = (ArrayList<Good>) goodService.queryObj(g);
        Collections.sort(list);*/
        renderJsonpObj(baseService.list(hql));
    }

    public void listType(){
        renderJsonpObj(typeService.list());
    }

    public void saveDingzuo(){
        Dingzuo dz = new Dingzuo();
        dz.setRenshu(request.getParameter("renshu"));
        dz.setXingming(encodeGet(request.getParameter("xingming")));
        dz.setShouji(request.getParameter("shouji"));
        dz.setShijian(request.getParameter("shijian"));
        dz.setTodate(request.getParameter("todate"));
        dz.setBeizhu(encodeGet(request.getParameter("beizhu")));
        dz.setShopid(request.getParameter("shopid"));
        dz.setShopname(encodeGet(request.getParameter("shopname")));
        dz.setOpenid(request.getParameter("openid"));
        dz.setNdate(GetNowTime.getNowTimeNian());
        dingzuoService.save(dz);
        renderJsonpString("提交成功!");
    }

    public void saveBill(){
        Bill bill = (Bill) getByRequest(new Bill(), true);

        bill.setNdate(GetNowTime.getNowTimeNian());

     
   
        billService.save(bill);
        //updateXiaoliang(bill);
        //insertLine(Integer.parseInt(bill.getUid()), bill.getId());
        renderJsonpObj(bill);

    }
    
    public void delBill(){
        String id= request.getParameter("bid");
        billService.delete(Integer.parseInt(id));
        renderJsonpString("提交成功!");

    }
    
    public void billState(){
    	String idstr = request.getParameter("id");
    	Bill b = billService.find(idstr);
    	String statecn = request.getParameter("statecn");
    	statecn = encodeGet(statecn);
    	b.setState(statecn);
    	b.setStatecn(statecn);
    	billService.update(b);
    	renderJsonpObj(b);
    }
    
    public void billCuidan(){
    	String idstr = request.getParameter("id");
    	Bill b = billService.find(idstr);
    	b.setCuidan("已催单");
    	billService.update(b);
    	renderJsonpObj(b);
    }

    public void saveBills(){
        String bills = request.getParameter("bills");
        bills = encodeGet(bills);
        JsonParser parser = new JsonParser();
        JsonArray blist = parser.parse(bills).getAsJsonArray();
        Bill bone = null;
        for(int i=0;i<blist.size();i++){
            JsonElement jo = blist.get(i);
            JsonObject obj = (JsonObject) parser.parse(jo.toString());
            Bill bill = new Bill();
            bill.setTotal(obj.get("total").getAsString());
            bill.setSid(obj.get("sid").getAsString());
            bill.setShop(obj.get("shop").getAsString());
            bill.setUid(obj.get("uid").getAsString());
            bill.setUser(obj.get("user").getAsString());
            bill.setNdate(GetNowTime.getNowTimeNian());
            bill.setGids(obj.get("gids").getAsString());
            bill.setGnames(obj.get("gnames").getAsString());
            bill.setAddress(obj.get("address").getAsString());
            bill.setTel(obj.get("tel").getAsString());
            bill.setNote(obj.get("note").getAsString());
            bill.setStatecn("未付款");
            bill.setCuidan("未催单");
            billService.save(bill);
            if(i==0){
            	bone = bill;
            }
            insertLine(Integer.parseInt(bill.getUid()), bill.getId());
        }

        renderJsonpObj(bone);
    }

    public void mybills(){
        String uid = request.getParameter("uid");
        String sid = request.getParameter("sid");
        String type = request.getParameter("type");
        
        Bill b = new Bill();
        if(uid!=null && !uid.equals("")){
        	 b.setUid(uid);
        }
        if(sid!=null && !sid.equals("")){
       	 b.setSid(sid);
        }
        if(type!=null && !type.equals("")){
        	type = encodeGet(type);
          	 b.setStatecn(type);
           }
        renderJsonpObj(billService.list(b));
    }
    public void myshopbills(){
        String sid = request.getParameter("sid");
        Bill b = new Bill();
        b.setSid(sid);
        renderJsonpObj(billService.list(b));
    }
    public Bill updateXiaoliang(Bill bill){
    	String gid = bill.getGids();
        Good g = goodService.find(gid);
        int count = 0;
        if(g.getXiaoliang()!=null){
        	count = g.getXiaoliang();
        }
        count++;
        g.setXiaoliang(count);
        goodService.update(g);        
        return bill;
    }

    public void deleteGood(){
        String id = request.getParameter("id");
        goodService.delete(Integer.parseInt(id));
        renderJsonpString("success");
    }
    public void deleteBill(){
        String id = request.getParameter("id");
        billService.delete(Integer.parseInt(id));
        renderJsonpString("success");
    }
    public void listReplay(){
    	String hql = "from Replay t where 1=1";
    	String pid = request.getParameter("pid");
    	String type = request.getParameter("type");
    	if(type!=null && !type.equals("")){
    		hql+=" and t.type="+type;
    	}
    	hql+=" and t.pid='"+pid+"'";
        renderJsonpObj(baseService.list(hql));
    }
    public void listNotice(){
        renderJsonpObj(noticeService.list());
    }
    public void listRoom(){
        renderJsonpObj(roomService.list());
    }
    
    public void addReplay(){
    	Replay m = (Replay) getByRequest(new Replay(), true);

    	String ndate = GetNowTime.getNowTimeEn();
    	m.setNdate(ndate);
    	replayService.save(m);
    	renderJsonpString("success");
    }
    
    public void getShouye(){
        Good g = new Good();
        g.setShouye(1);
        renderJsonpObj(goodService.list(g));
    }
    
    public void listBillGoods(){
    	String gids = request.getParameter("gids");
    	String hql = "from Good u where u.id in ("+gids+")";
    	renderJsonpObj(goodService.list(hql));
    }
    
    public void saveAddress(){
    	String action = request.getParameter("action");
    	if(action.equals("add")){
    		Address address = (Address) getByRequest(new Address(), true);
    		baseService.save(address);
    	}else{
    		Address address = (Address) getByRequest(new Address(), true);
    		baseService.update(address);
    	}
    	renderJsonpString("0");
    }
    
    public void delAddress(){
    	String id = request.getParameter("id");
    	baseService.delete(Integer.parseInt(id), Address.class);
    	renderJsonpString("0");
    }
    
    public void listAddress(){
    	String uid = request.getParameter("uid");
    	renderJsonpObj(baseService.list("from Address t where t.uid = "+uid));
    }
    
    public void getLineNumber(){
    	List<Line> list = baseService.list("from Line t order by id asc");
    	String bid = request.getParameter("bid");
    	int count = 0;
    	for(int i=0;i<list.size();i++){
    		Line l = list.get(i);
    		if(l.getBid()==Integer.parseInt(bid)){
    			break;
    		}else{
    			count++;
    		}
    	}
    	renderJsonpString(count+"");
    }
    
    public void insertLine(int uid,int bid){
    	Line line = new Line();
    	line.setUid(uid);
    	line.setBid(bid);
    	baseService.save(line);
    }
    
    public void getShop(){
    	String id = request.getParameter("id");
    	Shop shop = (Shop) baseService.find(Integer.parseInt(id), Shop.class);
    	renderJsonpObj(shop);
    }
    
    public void saveGood(){
    	String action  = request.getParameter("action");
    	Good info = (Good) getByRequest(new Good(), true);
    	if(action!=null && action.equals("edit")){
    		baseService.update(info);
    	}else{
    		baseService.save(info);
    	}
        renderJsonpString("success");
    }
    
    public void delGood(){
    	String id = request.getParameter("id");
    	baseService.delete(Integer.parseInt(id), Good.class);
    	renderJsonpString("0");
    }
    
    public void saveNotice(){
    	Notice info = (Notice) getByRequest(new Notice(), true);
    	baseService.save(info);
        renderJsonpString("success");
    }
    
    public void delNotice(){
    	String id = request.getParameter("id");
    	baseService.delete(Integer.parseInt(id), Notice.class);
    	renderJsonpString("0");
    }
    
    public void zan(){
    	String id = request.getParameter("id");
    	Good g = (Good) baseService.find(Integer.parseInt(id), Good.class);
    	Integer zan = g.getZan();
    	if(zan!=null){
    		zan++;
    	}else{
    		zan = 1;
    	}
    	g.setZan(zan);
    	baseService.update(g);
    	renderJsonpString(zan+"");
    }
    public void delPosts(){
    	String id = request.getParameter("id");
    	baseService.delete(Integer.parseInt(id), Posts.class);
    	renderJsonpString("success");
    }
    public void zan2(){
    	String id = request.getParameter("id");
    	Posts g = (Posts) baseService.find(Integer.parseInt(id), Posts.class);
    	Integer zan = g.getZan();
    	if(zan!=null){
    		zan++;
    	}else{
    		zan = 1;
    	}
    	g.setZan(zan);
    	baseService.update(g);
    	renderJsonpString(zan+"");
    }
    
    public void saveTousu(){
    	Tousu t = (Tousu) getByRequest(new Tousu(), true);
    	t.setNdate(GetNowTime.getNowTimeEn());
    	baseService.save(t);
    	renderJsonpString("0");
    }
    public void saveRizhi(){
    	Rizhi t = (Rizhi) getByRequest(new Rizhi(), true);
    	t.setNdate(GetNowTime.getNowTimeEn());
    	baseService.save(t);
    	renderJsonpString("0");
    }
    
    public void listRizhi(){
    	String hql = "from Rizhi t where 1=1";
    	String uid = request.getParameter("uid");
    	if(notNull(uid)){
    		hql+=" and t.uid='"+uid+"'";
    	}
    	renderJsonpObj(baseService.list(hql));
    }
    
    public void getGood(){
    	String id = request.getParameter("id");
    	Good g = (Good) baseService.find(Integer.parseInt(id), Good.class);
    	renderJsonpObj(g);
    }
    public void sendToClient(){
		String title = request.getParameter("title");
		String note = request.getParameter("note");
		String cid = request.getParameter("cid");
		Getui.sendToClient(title, note, cid);
		renderJsonpString("success");
	}
	
	public void sendToAll(){
		String title = request.getParameter("title");
		String note = request.getParameter("note");
		Getui.sendToAll(title, note);
		renderJsonpString("success");
	}
	public void bindClient() {
		String uid = request.getParameter("uid");
		String clientid = request.getParameter("clientid");
		User user = userService.find(uid);
		if(user!=null){
			user.setClientId(clientid);
			userService.update(user);
			renderJsonpString("success");
		}else{
			renderJsonpString("fail");
		}		
	}
	
	public void addPosts(){
		Posts p = (Posts) getByRequest(new Posts(), true);

    	String ndate = GetNowTime.getNowTimeEn();

    	p.setNdate(ndate);

    	baseService.save(p);
    	renderJsonpString("success");
    }
    public void listPosts(){
        renderJsonpObj(baseService.list("from Posts order by zan desc"));
    }
    
    public void listVideo(){
    	String hql = "from Video t where 1=1";
    	String type = request.getParameter("type");
    	if(notNull(type)){
    		hql+=" and t.type='"+type+"'";
    	}
    	renderJsonpObj(baseService.list(hql));
    }
    
    public void getWeather(){
    	try {
    		String city = request.getParameter("city");
    		city = encodeGet(city);
			city = URLEncoder.encode(city,"utf-8");
			String url = "http://api.map.baidu.com/telematics/v3/weather?location="+city+"&output=json&ak=W6eQXHTZjNf7QTG9k9Mpboez";		
			String r = HttpClientTools.get(url);
		
			renderJsonpString(r);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void getChoose(){
    	String hql = "from Choose t where 1=1";
    	String type = request.getParameter("type");
    	String shijuanid = request.getParameter("shijuanid");
    	if(shijuanid!=null && !shijuanid.equals("")){
    		Shijuan sj = (Shijuan) baseService.find(Integer.parseInt(shijuanid), Shijuan.class);
        	String cids = sj.getCids();
        	hql += " and t.id in ("+cids+")";
    	}else if(type!=null && !type.equals("")){
    		hql+=" and t.typeid="+type;
    	}
    	renderJsonpObj(baseService.list(hql));
    }
    
    public void getPdt(){
    	String hql = "from Pdt t where 1=1";
    	String type = request.getParameter("type");
    	if(type!=null && !type.equals("")){
    		hql+=" and t.typeid="+type;
    	}
    	renderJsonpObj(baseService.list(hql));
    }
    
    public void saveToFavs(){
    	User u = (User) baseService.find(Integer.parseInt(request.getParameter("uid")), User.class);
    	String favs = request.getParameter("favs");
    	u.setFavs(favs);
    	baseService.update(u);
    	renderJsonpObj(u);
    }
    
    public void saveToCuotis(){
    	User u = (User) baseService.find(Integer.parseInt(request.getParameter("uid")), User.class);
    	String cuotis = request.getParameter("cuotis");
    	u.setCuotis(cuotis);
    	baseService.update(u);
    	renderJsonpObj(u);
    }
    
    public void listMyFavs(){
    	User u = (User) baseService.find(Integer.parseInt(request.getParameter("uid")), User.class);
    	String favs = u.getFavs();
    	if(favs!=null && !favs.equals("")){
    		String hql = "from Choose t where t.id in ("+favs+")";
    		renderJsonpObj(baseService.list(hql));
    	}else{
    		renderJsonpObj(null);
    	}
    }
    public void listMyCuotis(){
    	User u = (User) baseService.find(Integer.parseInt(request.getParameter("uid")), User.class);
    	String favs = u.getCuotis();
    	if(favs!=null && !favs.equals("")){
    		String hql = "from Choose t where t.id in ("+favs+")";
    		renderJsonpObj(baseService.list(hql));
    	}else{
    		renderJsonpObj(null);
    	}
    }
    
    
    public void listShijuan(){
    	String hql = "from Shijuan t where 1=1";
    	String type = request.getParameter("type");
    	if(notNull(type)){
    		hql+=" and t.type='"+type+"'";
    	}
    	renderJsonpObj(baseService.list(hql));
    }
    
    public void getShijuanChoose(){
    	String id = request.getParameter("id");
    	Shijuan sj = (Shijuan) baseService.find(Integer.parseInt(id), Shijuan.class);
    	String cids = sj.getCids();
    	String hql = "from Choose t where 1=1 and t.id in ("+cids+")";
    	renderJsonpObj(baseService.list(hql));
    }
    
    public void updateChoose(){
    	Choose choose = (Choose) getByRequest(new Choose(), true);
    	baseService.update(choose);
    	renderJsonpString("0");
    }
    
}
