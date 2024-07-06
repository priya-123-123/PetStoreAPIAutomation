package pojo;

import java.util.ArrayList;
import java.util.Random;

public class TagsPOJO {
	private int id;
	private String name;
	public TagsPOJO() {
		super();
	}
	public TagsPOJO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean equals(TagsPOJO tg) {
		return (tg.id==this.id && tg.name.equals(this.name));
	}
	
	
	public static boolean compareTo(ArrayList<TagsPOJO>tg1, ArrayList<TagsPOJO>tg2) {
		int count=0;
		boolean equal=false;
		for(int i=0;i<tg1.size();i++) {
			/*
			 * System.out.println(tg1.get(i).getId()==tg2.get(i).getId());
			 * System.out.println(tg1.get(i).getName().equals(tg2.get(i).getName()));
			 */
			if(tg1.get(i).getId()==tg2.get(i).getId()  && tg1.get(i).getName().equals(tg2.get(i).getName())) {;
				
				count = count+1;
				System.out.println(count);
			}
			System.out.println(count);
			if(count==tg1.size() ) {
				equal= true;
			}else {
				equal= false;
			}

			 
			
		}
		return equal;
	}
}
