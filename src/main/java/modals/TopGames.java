package modals;

import java.util.Arrays;

public class TopGames {

	Games data[];
	Pagination pagination;
	public Games[] getData() {
		return data;
	}
	public void setData(Games[] data) {
		this.data = data;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	@Override
	public String toString() {
		return "TopGames [data=" +"\n"+ Arrays.toString(data) + ","+"\n"
				+ " pagination=" + pagination + "]";
	}
	
	
	
	
}
