package com.ideabobo.service;

import java.util.List;
import java.util.Map;

import com.ideabobo.model.Rizhi;
import com.ideabobo.util.Page;

public interface RizhiService {
	public void save(Rizhi model);
	public void update(Rizhi model);
	public Rizhi find(String uuid);
	public Rizhi find(Rizhi model);
	public void delete(Integer uuid);
	public List<Rizhi> list();
    public List<Rizhi> list(Rizhi model);
	public Page findByPage(Page page,Map paramsMap);
}
