package modals;

public class Games {

	String id;
	String name;
	String box_art_url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBox_art_url() {
		return box_art_url;
	}
	public void setBox_art_url(String box_art_url) {
		this.box_art_url = box_art_url;
	}
	@Override
	public String toString() {
		return "Games [id=" + id + ", name=" + name + ", box_art_url=" + box_art_url + "]";
	}
	
	
	
	
}
