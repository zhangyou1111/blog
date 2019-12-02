package com.company.util;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.pojo.Invitation;
@Component
public class Show  implements Serializable{
	private List<Invitation> list;
	private Integer num;
	private Integer count;
	public List<Invitation> getList() {
		return list;
	}
	public void setList(List<Invitation> list) {
		this.list = list;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

}
