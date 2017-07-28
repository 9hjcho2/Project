package Beat_please;

public class Track {//하나의 곡에 대한 정보를 담기 위한 클래스
	
	private String lobbyImage; //게임 선택 창 표지 이미지
	//private String lobbyMusic; //게임 선택 창 음악
	private String gameImage; // 해당 곡을 실행했을 때 표지 이미지
	private String gameMusic; //해당 곡을 실행했을 때 음악
	
	
	public String getLobbyImage() {
		return lobbyImage;
	}
	public void setLobbyImage(String lobbyImage) {
		this.lobbyImage = lobbyImage;
	}
//	public String getLobbyMusic() {
//		return lobbyMusic;
//	}
//	public void setLobbyMusic(String lobbyMusic) {
//		this.lobbyMusic = lobbyMusic;
//	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	
	
	public Track(String lobbyImage, String gameImage, String gameMusic) { //생성자
		super();
		this.lobbyImage = lobbyImage;
		this.gameImage = gameImage;
		this.gameMusic = gameMusic;
	
	}
	
	

}