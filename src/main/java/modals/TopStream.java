package modals;

import java.util.Arrays;

public class TopStream {
	
	String[] data;
	String[] tag_ids;
	Pagination pagination;
	public String[] getData() {
		return data;
	}
	public void setData(String[] data) {
		this.data = data;
	}
	public String[] getTag_ids() {
		return tag_ids;
	}
	public void setTag_ids(String[] tag_ids) {
		this.tag_ids = tag_ids;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	@Override
	public String toString() {
		return "TopStream [data=" + Arrays.toString(data) + ", tag_ids=" + Arrays.toString(tag_ids) + ", pagination="
				+ pagination + "]";
	}
	
	
	

}
