package pojo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class PetPojoClass {
	private int id;
	private CategoryPOJO category;
	private String name;
	private String[] photoUrls;
	private ArrayList<TagsPOJO> tags;
	private String status;
	private String additionalMetadata;
	private File	file;
	
	public PetPojoClass() {
		super();
	}
	
	public PetPojoClass(String additionalMetadata, File file) {
		super();
		this.additionalMetadata = additionalMetadata;
		this.file = file;
	}

	public PetPojoClass(int id, CategoryPOJO category, String name, String[] photoUrls, ArrayList<TagsPOJO> tags,
			String status) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}
	
	public String getAdditionalMetadata() {
		return additionalMetadata;
	}

	public void setAdditionalMetadata(String additionalMetadata) {
		this.additionalMetadata = additionalMetadata;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CategoryPOJO getCategory() {
		return category;
	}
	public void setCategory(CategoryPOJO category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String[] getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}
	public ArrayList<TagsPOJO> getTags() {
		return tags;
	}
	public void setTags(ArrayList<TagsPOJO> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean equals(PetPojoClass pg) {
		return (pg.id==this.id) && (pg.name.equals(this.name)) && (pg.status.equals(this.status))
				&&(Arrays.equals(pg.photoUrls, this.photoUrls)) && (pg.category.equals(this.category)) &&(TagsPOJO.compareTo(pg.tags, this.tags)) ;
				
	}
	

}
