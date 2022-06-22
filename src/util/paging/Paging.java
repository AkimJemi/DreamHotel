package util.paging;

public class Paging {
	private int total;
	private int currentPage;
	private int limit=10;
	private int begin;
	private int end;
	private Boolean forward;
	private Boolean backward;
	private int searchTitle;
	private String searchContent;

	public Paging(int total, int currentPage, int searchTitle, String searchContent) {
		this.total = total;
		this.currentPage = currentPage;
		this.searchTitle = searchTitle;
		this.searchContent = searchContent;
		for (int i = 1; i > -1; i++) {
			if (currentPage >= (i - 1) * 5 + 1 && currentPage <= i * 5) {
				begin = (i - 1) * 5 + 1;
				if (begin + 4 <= total / limit) {
					end = i * 5;
					forward = true;
				} else {
					if (total % limit == 0)
						end = total / limit;
					else
						end = total / limit + 1;
				}
				if (currentPage >= end) {
					this.currentPage = end;
					for (int j = 1; j > -1; j++) {
						if (end >= (j - 1) * 5 + 1 && end <= j * 5) {
							begin = (j - 1) * 5 + 1;
							break;
						}
					}
				}
				if (begin <= 5)
					backward = false;
				else
					backward = true;
				break;
			}
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Boolean getForward() {
		return forward;
	}

	public void setForward(Boolean forward) {
		this.forward = forward;
	}

	public Boolean getBackward() {
		return backward;
	}

	public void setBackward(Boolean backward) {
		this.backward = backward;
	}

	public int getSearchTitle() {
		return searchTitle;
	}

	public void setSearchTitle(int searchTitle) {
		this.searchTitle = searchTitle;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

}
