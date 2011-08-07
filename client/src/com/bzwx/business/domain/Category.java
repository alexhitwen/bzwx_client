package com.bzwx.business.domain;
/**
 * com.bzwx.business.domain.Category
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-8-5
 */
public class Category {

	private int cateId; // 类别 主键（int即可）
	private int parentId; // 类别父键
	private String cateName;// 类别显示名称
	private String cateCode;// 类别代号
	private String cateValue;// 类别代号
	private String cateNote;// 类别描述
	private String cateDesc;// 类别详细描述（来历、做法等）
	private int sortFlag; // 排序字段

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateValue() {
		return cateValue;
	}

	public void setCateValue(String cateValue) {
		this.cateValue = cateValue;
	}

	public String getCateNote() {
		return cateNote;
	}

	public void setCateNote(String cateNote) {
		this.cateNote = cateNote;
	}

	public String getCateDesc() {
		return cateDesc;
	}

	public void setCateDesc(String cateDesc) {
		this.cateDesc = cateDesc;
	}

	public int getSortFlag() {
		return sortFlag;
	}

	public void setSortFlag(int sortFlag) {
		this.sortFlag = sortFlag;
	}

}
