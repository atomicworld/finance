package com.mf.flowmng.entity;
/**
 * 
 * @author fangzp
 * 流程设计器独用
 */
public class LineBean {
  private String linesName;
  private String type;
  private String from;
  private String to;
  private String name;
  private String alt;
  
public String getLinesName() {
	return linesName;
}
public void setLinesName(String linesName) {
	this.linesName = linesName;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
}
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAlt() {
	return alt;
}
public void setAlt(String alt) {
	this.alt = alt;
}
  
}
