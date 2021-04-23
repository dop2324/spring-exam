package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword;
	
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		
		return type == null? new String[] {}: type.split("");
		// 3항 연산자.
		// type이 null 이면 new String[] 아니면 type.split("");
		                                     // 문자열을 나눌때 사용한다.
	}
	
	/*
	 * public Map<String, String> getMap(){ if(type == null || type.trim().length()
	 * == 0) { return null; } //T,C,w String[] arr = type.split("");
	 * Map<String,String> map = new HashMap<>(); for(String word: arr) {
	 * map.put(word, keyword); } return map; }
	 */
	public String getListLink() {
	    
	    UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
	        .queryParam("pageNum", this.pageNum)
	        .queryParam("amount", this.getAmount())
	        .queryParam("type",this.getType())
	        .queryParam("keyword", this.getKeyword());
	    
	    return builder.toUriString();
	    
	  }
	
}
