package com.ideabobo.service;

import java.util.List;
import java.util.Map;

import com.ideabobo.model.Video;
import com.ideabobo.util.Page;

public interface VideoService {
	public void save(Video model);
	public void update(Video model);
	public Video find(String uuid);
	public Video find(Video model);
	public List<Video> list(Video model);
	public List<Video> list(String hql);
	public void delete(Integer uuid);
	public List<Video> list();
	public Page findByPage(Page page,Map paramsMap);
}
