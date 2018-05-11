package com.groupware.dto.address;

public class AddressBookVO {
	private String id;
	private String name;
	private String pId;
	private String pName;
	private String mem_em; 
	private String mem_tel;
	private String pos_nm;
	private String mem_img;
	
	public AddressBookVO(AddressViewVO address) {
		this.id= address.getMem_num();
		this.name = address.getMem_nm();
		this.pId = address.getDep_code();
		this.pName = address.getDep_nm();
		this.mem_em = address.getMem_em();
		this.mem_tel = address.getMem_tel();
		this.pos_nm = address.getPos_nm();
		this.mem_img = address.getMem_img();
	}

	public String getMem_img() {
		return mem_img;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getpId() {
		return pId;
	}

	public String getpName() {
		return pName;
	}

	public String getMem_em() {
		return mem_em;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public String getPos_nm() {
		return pos_nm;
	}
}
