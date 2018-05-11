package com.groupware.dto.address;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class JsonParseVO {

	public HashMap<String,ArrayList<AddressBookVO>> jsonList = new HashMap<String, ArrayList<AddressBookVO>>();
	
	public JsonParseVO(ArrayList<AddressViewVO> addressList) {
		TreeSet<String> keySet = new TreeSet<String>(); 
		for(AddressViewVO address : addressList){
			keySet.add(address.getDep_nm());
		}
		
		for(String cn : keySet){ 
			ArrayList<AddressBookVO> list = new ArrayList<AddressBookVO>();
			for(int i=0; i<addressList.size();i++){
				if(cn.equals(addressList.get(i).getDep_nm())){
					list.add(new AddressBookVO(addressList.get(i)));
				}
			}
			jsonList.put(cn, list);
		}
	}
}