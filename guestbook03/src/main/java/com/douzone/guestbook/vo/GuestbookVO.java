package com.douzone.guestbook.vo;

public class GuestbookVO {
	private Long no;
	private String name;
	private String contents;
	private String pw;
	private String regDate;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "GuestbookVO [no=" + no + ", name=" + name + ", contents=" + contents + ", pw=" + pw + ", regDate="
				+ regDate + "]";
	}

}
