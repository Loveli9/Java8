package lambdasinaction.chap5;

import lombok.Data;

@Data
public  class Trader {

	private String name;
	private String city;

	public Trader(String n, String c) {
		this.name = n;
		this.city = c;
	}

}