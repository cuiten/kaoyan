package com.ideabobo.service;

import java.util.List;
import java.util.Map;

import com.ideabobo.model.Pdt;
import com.ideabobo.util.Page;

public interface PdtService {
	public void save(Pdt model);
	public void update(Pdt model);
	public Pdt find(String uuid);
	public Pdt find(Pdt model);
	public void delete(Integer uuid);
	public List<Pdt> list();
	public Page findByPage(Page page,Map paramsMap);
}
