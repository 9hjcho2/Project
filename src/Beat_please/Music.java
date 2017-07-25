package Beat_please;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player; // Player는 다운받은 라이브러리 중 하나
	private boolean isLoop;// 현재 곡을 무한반복할지 한번 재생하고 꺼질지 설정
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop)//생성자 : 곡의 제목과 해당 곡을 무한반복 할지
	{
		try// try catch문은 예외 처리를 위해 사용하는 구문, 안 쓰면 오류남. 왜??
		{
			this.isLoop = isLoop; //isLoop 변수 초기화
			file = new File(Main.class.getResource("../music/" + name).toURI()); //뮤직이라는 폴더 안에 있는 해당 파일을 가져오기.
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis); // 해당파일 버퍼에 담아 읽을 수 있게 함.
			player = new Player(bis); // 해당파일을 담을 수 있게 해줌
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() // 현재 실행되고 있는 음악이 어떤 위치에 실행되고 있는지 알려줌. 시간 분석
	{
		if (player == null)
			return 0;
		return player.getPosition();
	}
	public void close() // 음악 종료를 할 수 있도록 하는 함수.
	{
		isLoop = false;
		player.close();
		this.interrupt(); // 해당 쓰레드를 중지 상태로 만듬.
	}
	
	@Override
	public void run() //쓰레드를 상속받으면 무조건 사용해야되는 함수.
	{
		try
		{
			do
			{
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis); // 해당파일 버퍼에 담아 읽을 수 있게 함.
				player = new Player(bis); // 해당파일을 담을 수 있게 해줌
			}
			while(isLoop);//트루값을 가지면 곡을 무한반복함
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
