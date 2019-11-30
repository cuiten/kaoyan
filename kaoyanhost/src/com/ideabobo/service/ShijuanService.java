package com.ideabobo.service;

import java.util.List;
import java.util.Map;

import com.ideabobo.model.Shijuan;
import com.ideabobo.util.Page;

public interface ShijuanService {
	public void save(Shijuan model);
	public void update(Shijuan model);
	public Shijuan find(String uuid);
	public Shijuan find(Shijuan model);
	public void delete(Integer uuid);
	public List<Shijuan> list();
	public List<Shijuan> list(Shijuan model);
	public Page findByPage(Page page,Map paramsMap);
}
