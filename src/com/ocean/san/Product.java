```java
package com.ocean.san;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {

	/**
	 * 八种基本类型
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * 整数类型
	 */
	private long id;
	private short code;
	private int size;
	private byte zone;
	/**
	 * 
	 * 浮点类型
	 */
	private double price;
	private float node;
	/**
	 * 
	 * 字符类型
	 */
	private char type;
	/**
	 * 
	 * 布尔类型
	 */
	private boolean flag;
	/**
	 * 
	 * 其他类型
	 */
	private String name;
	private Date startDt;
	private Date endDt;
	private byte[] other;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public short getCode() {
		return code;
	}

	public void setCode(short code) {
		this.code = code;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public float getNode() {
		return node;
	}

	public void setNode(float node) {
		this.node = node;
	}

	public String getName() {
		return name;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public byte[] getOther() {
		return other;
	}

	public void setOther(byte[] other) {
		this.other = other;
	}

	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public byte getZone() {
		return zone;
	}

	public void setZone(byte zone) {
		this.zone = zone;
	}

}
```
