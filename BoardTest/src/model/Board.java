package model;

public class Board {

	private int no;
	private String subject;
	private String content;
	private String wdate;
	private int cnt;
	private String id;
	
	public Board() {}
	
	public Board(int no, int cnt) {
		this.no = no;
		this.cnt = cnt;
	}

	public Board(int no, String subject, String content) {
		this.no = no;
		this.subject = subject;
		this.content = content;
	}

	public Board(String subject, String content, String id) {
		this.subject = subject;
		this.content = content;
		this.id = id;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}


