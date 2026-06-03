package es.yisus.utils;

public class Leaderboard implements Comparable<Leaderboard> {
	private String nickname;
	private Integer score;
	
	public Leaderboard(String nickname, Integer score) {
		this.nickname = nickname;
		this.score = score;
	}
	public Leaderboard() {
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public int compareTo(Leaderboard o) {
		return this.score - o.getScore();
	}
	
	

}
