package model.post;


public class PostVO {
	private int postnum;
	private String id;
	private String title;
	private String postdate;
	private String content;
	
	@Override
	public String toString() {
		return "PostVO [postnum=" + postnum + ", id=" + id + ", title=" + title + ", postdate=" + postdate + ", content="
				+ content + "]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPostnum() {
		return postnum;
	}
	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	
}
