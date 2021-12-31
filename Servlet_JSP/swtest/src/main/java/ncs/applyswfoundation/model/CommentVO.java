package ncs.applyswfoundation.model;

public class CommentVO {

	private int no;
	private String commentContents;
	private String writeDate;
	
	public CommentVO() {}
	
	public CommentVO(int no, String commentContents, String writeDate) {
		this.no = no;
		this.commentContents = commentContents;
		this.writeDate = writeDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCommentContents() {
		return commentContents;
	}

	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}

	public String getwriteDate() {
		return writeDate;
	}

	public void setwriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
		
}