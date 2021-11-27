package edu.kh.project.game.model.vo;

public class Game {
	
	private int gameNo;
	private int rpsScore;
	private int userNo;
	private String userId;
    private String userName;
    private int rpsWl;
    private int rpsRank;
    private int rpsYn;
	private int upDownScore;
	private int upDownRank;
	private int upDownYn;


	
	public Game() {
		super();
	}
	
	public int getUpDownScore() {
		return upDownScore;
	}

	public void setUpDownScore(int upDownScore) {
		this.upDownScore = upDownScore;
	}

	public int getUpDownRank() {
		return upDownRank;
	}

	public void setUpDownRank(int upDownRank) {
		this.upDownRank = upDownRank;
	}

	public int getUpDownYn() {
		return upDownYn;
	}

	public void setUpDownYn(int upDownYn) {
		this.upDownYn = upDownYn;
	}

	public int getRpsYn() {
		return rpsYn;
	}

	public void setRpsYn(int rpsYn) {
		this.rpsYn = rpsYn;
	}


	public int getRpsRank() {
		return rpsRank;
	}

	public void setRpsRank(int rpsRank) {
		this.rpsRank = rpsRank;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getGameNo() {
		return gameNo;
	}
	
	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	
	public int getRpsScore() {
		return rpsScore;
	}
	
	public void setRpsScore(int rpsScore) {
		this.rpsScore = rpsScore;
	}
	
	public int getUserNo() {
		return userNo;
	}
	
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	public int getRpsWl() {
		return rpsWl;
	}


	public void setRpsWl(int rpsWl) {
		this.rpsWl = rpsWl;
	}

	@Override
	public String toString() {
		return "Game [gameNo=" + gameNo + ", rpsScore=" + rpsScore + ", userNo=" + userNo + ", userId=" + userId
				+ ", userName=" + userName + ", rpsWl=" + rpsWl + ", rpsRank=" + rpsRank + ", rpsYn=" + rpsYn
				+ ", upDownScore=" + upDownScore + ", upDownRank=" + upDownRank + ", upDownYn=" + upDownYn + "]";
	}

	


	
}
