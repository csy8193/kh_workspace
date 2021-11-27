package edu.kh.jdbc.board.model.vo;

import java.sql.Date;

public class Board {
	
	private int BoardNo;
	private String BoardTitle;
	private String BoardContent;
	private Date CreateDt;
	private int ReadCount;
	private int BoardWriter; // 작성자 회원 번호
	private String memberNm; // 작성자 회원 이름
	private char mm;
	
	
	// 기본 생성자
	public Board() {
		super();
	}
	
	public Board(int boardNo, String boardTitle, Date createDt, int readCount, String memberNm) {
		super();
		BoardNo = boardNo;
		BoardTitle = boardTitle;
		CreateDt = createDt;
		ReadCount = readCount;
		this.memberNm = memberNm;
	}


	// getter / setter
	public int getBoardNo() {
		return BoardNo;
	}

	public void setBoardNo(int boardNo) {
		BoardNo = boardNo;
	}

	public String getBoardTitle() {
		return BoardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		BoardTitle = boardTitle;
	}

	public String getBoardContent() {
		return BoardContent;
	}

	public void setBoardContent(String boardContent) {
		BoardContent = boardContent;
	}

	public Date getCreateDt() {
		return CreateDt;
	}

	public void setCreateDt(Date createDt) {
		CreateDt = createDt;
	}

	public int getReadCount() {
		return ReadCount;
	}

	public void setReadCount(int readCount) {
		ReadCount = readCount;
	}

	public int getBoardWriter() {
		return BoardWriter;
	}

	public void setBoardWriter(int boardWriter) {
		BoardWriter = boardWriter;
	}

	public String getMemberNm() {
		return memberNm;
	}

	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	@Override
	public String toString() {
		return "Board [BoardNo=" + BoardNo + ", BoardTitle=" + BoardTitle + ", BoardContent=" + BoardContent
				+ ", CreateDt=" + CreateDt + ", ReadCount=" + ReadCount + ", BoardWriter=" + BoardWriter + ", memberNm="
				+ memberNm + "]";
	}
	
	
	
}
