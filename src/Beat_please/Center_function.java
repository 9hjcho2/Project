package Beat_please;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics; //더블버퍼링을 위한 라이브러리
import java.awt.Image;    //더블버퍼링을 위한 라이브러리
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;//ImageIcon 라이브러리
import javax.swing.JButton; //JButton 라이브러리
import javax.swing.JFrame; //JFrame클래스의 라이브러리
import javax.swing.JLabel; //JLabel클래스의 라이브러리

public class Center_function extends JFrame {//JFrame은 자바에서 text기반 프로그래밍이 아니라 GUI기반의 프로그래밍으로 만들기 위해 기본적으로 상속받아야 할것. 라이브러리는 위에 import해줌
	
	//더블 버퍼링: 이미지를 화면에 띄우는 방식은 버퍼링이 심하다. 그래서 더블 버퍼링을 사용. -> 현재프로그램을 전체화면 크기에 맞는 이미지를 매순간마다 생성해서 원하는 컴퍼런트만 화면에 출력하는 방식.
	private Image screenImage; // 더블버퍼링을 위해서 전체 화면에 대한 이미지를 담는 do instance
	private Graphics screenGraphic;// 더블버퍼링을 위해서 전체 화면에 대한 이미지를 담는 do instance
	
	private ImageIcon exitButtonEnteredImage =new ImageIcon(Main.class.getResource("../images/exitButtonEntered.jpg")); //이미지 초기화
	private ImageIcon exitButtonBasicImage =new ImageIcon(Main.class.getResource("../images/exitButtonBasic.jpg")); 
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.jpg")); 
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.jpg")); 
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.jpg")); 
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.jpg")); 
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.jpg")); 
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.jpg")); 
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.jpg")); 
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.jpg")); 
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();//Background 이미지를 담을 수 있는 객체를 초기화
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.jpg"))); //menuBar라는 객체 안에 menuBar.jpg 이미지을 초기화
	
	private JButton exitButton = new JButton(exitButtonBasicImage); //exitButton라는 객체 안에 exitButtonBasic.jpg 초기화(버튼에 이미지를 초기화)
	private JButton startButton = new JButton(startButtonBasicImage); //이미지 초기화
	private JButton quitButton = new JButton(quitButtonBasicImage); //이미지 초기화
	private JButton leftButton = new JButton(leftButtonBasicImage); //이미지 초기화
	private JButton rightButton = new JButton(rightButtonBasicImage); //이미지 초기화
	
	private int mouseX, mouseY; // 프로그램 안에서 마우스의 X, Y 좌표를 의미함. 드래그해서 화면이 이동하게 만들기 위해 쓴다.
	
	private boolean isMainScreen = false; // 처음엔 인트로화면이고 mainBackground에서 트루로 바꿔준다.
	
	ArrayList<Track> trackList = new ArrayList<Track>(); //각각의 곡 ,트랙을 담을 수 있는 list를 배열로 만든것
	
	private Image titleImage; //titleImage 선언    		 //7장부턴 아님:"정은지 Title Image"로 이미지 초기화
	private Image selectedImage; //selectedImage 선언		 //7장부턴 아님: "정은지 Start Image"로 이미지 초기화
	private Music selectedMusic; // selectedMusic 변수 선언
	private int nowSelected = 0; //현재선택된 번호 선언. 초기화로 0
	
	public Center_function()/////// 생성자
	{
		setUndecorated(true); //기본적으로 존재하는 메뉴바가 보이지않게됨.
		setTitle("Dynamic Beat"); 
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //메인에 있는 그래픽 크기
		setResizable(false);//한번 선언된 그래픽을 사용자가 임의로 바꾸지 못하게 함.
		setLocationRelativeTo(null);//실행시 화면 중앙에 띄움.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창 종료시 프로그램 전체가 종료됨.: 안할시 프로그램을 끄더라도 컴퓨터 내부에서 계속 돌아감
		setVisible(true);//화면창이 보이게한다
		setBackground(new Color(0, 0, 0, 0));//paintComponents를 했을때 배경이 전부 흰색으로 바뀜
		setLayout(null); //버튼이나 JLabel을 넣었을 때 그 위치에 꽂힘.
		
		Music introMusic = new Music("introMusic.mp3", true); //시작화면에서 음악이 무한 반복되게 한다.
		introMusic.start(); //뮤직 시작
		
		trackList.add(new Track("정은지 Title Image.png", "정은지 Start Image.jpg", "정은지 Game Image.jpg", "정은지 Selected.mp3", "정은지.mp3")); //5개의 매개변수가 들어감. 초기화. Track List ?? 이거 좀 잘 모르겟다. 곡관리를 위해 씀
		trackList.add(new Track("창모 Title Image.png", "창모 Start Image.jpg", "창모 Game Image.jpg", "창모 Selected.mp3", "창모.mp3"));
		trackList.add(new Track("캐논 Title Image.png", "캐논 Start Image.png", "캐논 Game Image.png", "캐논 Selected.mp3", "캐논.mp3"));
		
		exitButton.setBounds(1245, 0, 30, 30); // 위치와 크기 정해줌
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter(){ //마우스에 대한 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e){ //마우스가 해당버튼에 올라왔을 때 이벤트처리
				exitButton.setIcon(exitButtonEnteredImage); //exitButton의 아이콘을 exitButtonEnteredImage의 이미지로 바꿔줌
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 올라갔을 때 커서가 손가락 모양으로 바뀜
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);//마우스가 올라갔을 때 소리 재생하게, 반복 안하게
				buttonEnteredMusic.start(); //음악 시작
			}
			@Override
			public void mouseExited(MouseEvent e){ //마우스가 해당버튼에서 나왔을 때 이벤트처리
				exitButton.setIcon(exitButtonBasicImage); //exitButton의 아이콘을 exitButtonBasicImage의 이미지로 바꿔줌
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//마우스가 나왓을 때 커서가 다시 돌아옴.
			}
			@Override
			public void mousePressed(MouseEvent e){ // 마우스가 이미지를 눌렀을 때 이벤트처리
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //마우스 눌렀을 때 소리 재생하게, 반복재생 안하게
				buttonEnteredMusic.start(); //음악 시작
				introMusic.close();
				try{
					Thread.sleep(4000); //1초있다 프로그램 종료되게 하기위해
				}catch (InterruptedException ex){
					ex.printStackTrace(); // 이거 뭐냐?? 근원지를 찾아서 단계별로 에러는 출력?? 뭔소리??
				}
				System.exit(0); //화면 꺼짐
			}
		});
		add(exitButton); //JButton에 버튼 추가됨.
		
		startButton.setBounds(540, 300, 200, 70); // 위치와 크기 정해줌
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter(){ //마우스에 대한 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e){ //마우스가 해당버튼에 올라왔을 때 이벤트처리
				startButton.setIcon(startButtonEnteredImage); //startButton의 아이콘을 startButtonEnteredImage의 이미지로 바꿔줌
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 올라갔을 때 커서가 손가락 모양으로 바뀜
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);//마우스가 올라갔을 때 소리 재생하게, 반복 안하게
				buttonEnteredMusic.start(); //음악 시작
			}
			@Override
			public void mouseExited(MouseEvent e){ //마우스가 해당버튼에서 나왔을 때 이벤트처리
				startButton.setIcon(startButtonBasicImage); //exitButton의 아이콘을 exitButtonBasicImage의 이미지로 바꿔줌
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//마우스가 나왓을 때 커서가 다시 돌아옴.
			}
			@Override
			public void mousePressed(MouseEvent e){ // 마우스가 이미지를 눌렀을 때 이벤트처리
				Music buttonEnteredMusic = new Music("buttonPressedStart.mp3", false); //마우스 눌렀을 때 소리 재생하게, 반복재생 안하게
				buttonEnteredMusic.start(); //음악 시작
				introMusic.close();
				try{
					Thread.sleep(1000); //1초있다 프로그램 종료되게 하기위해
				}catch (InterruptedException ex){
					ex.printStackTrace(); // 이거 뭐냐?? 근원지를 찾아서 단계별로 에러는 출력?? 뭔소리??
				}
				selectTrack(0);
				startButton.setVisible(false);//startButton 안보이게
				quitButton.setVisible(false);//quitButton 안보이게
				leftButton.setVisible(true); //leftButton 보이게한다.
				rightButton.setVisible(true);//rightButton 보이게한다.
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();// background 이미지를 mainBackground로 바꿈
				isMainScreen = true; // mainBackground에서 트루로 반환
			}
		});
		add(startButton); //JButton에 버튼 추가됨.
		
		quitButton.setBounds(540, 420, 200, 70); // 위치와 크기 정해줌
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter(){ //마우스에 대한 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e){ //마우스가 해당버튼에 올라왔을 때 이벤트처리
				quitButton.setIcon(quitButtonEnteredImage); //quitButton의 아이콘을 quitButtonEnteredImage의 이미지로 바꿔줌
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 올라갔을 때 커서가 손가락 모양으로 바뀜
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);//마우스가 올라갔을 때 소리 재생하게, 반복 안하게
				buttonEnteredMusic.start(); //음악 시작
			}
			@Override
			public void mouseExited(MouseEvent e){ //마우스가 해당버튼에서 나왔을 때 이벤트처리
				quitButton.setIcon(quitButtonBasicImage); //quitButton의 아이콘을 quitButtonBasicImage의 이미지로 바꿔줌
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//마우스가 나왓을 때 커서가 다시 돌아옴.
			}
			@Override
			public void mousePressed(MouseEvent e){ // 마우스가 이미지를 눌렀을 때 이벤트처리
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //마우스 눌렀을 때 소리 재생하게, 반복재생 안하게
				buttonEnteredMusic.start(); //음악 시작
				introMusic.close();
				try{
					Thread.sleep(4000); //1초있다 프로그램 종료되게 하기위해
				}catch (InterruptedException ex){
					ex.printStackTrace(); // 이거 뭐냐?? 근원지를 찾아서 단계별로 에러는 출력?? 뭔소리??
				}
				System.exit(0); //화면 꺼짐
			}
		});
		add(quitButton); //JButton에 버튼 추가됨.
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60); // 위치와 크기 정해줌
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter(){ //마우스에 대한 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e){ //마우스가 해당버튼에 올라왔을 때 이벤트처리
				leftButton.setIcon(leftButtonEnteredImage); //leftButton의 아이콘을 leftButtonEnteredImage의 이미지로 바꿔줌
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 올라갔을 때 커서가 손가락 모양으로 바뀜
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);//마우스가 올라갔을 때 소리 재생하게, 반복 안하게
				buttonEnteredMusic.start(); //음악 시작
			}
			@Override
			public void mouseExited(MouseEvent e){ //마우스가 해당버튼에서 나왔을 때 이벤트처리
				leftButton.setIcon(leftButtonBasicImage); //leftButton의 아이콘을 leftButtonBasicImage의 이미지로 바꿔줌
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//마우스가 나왓을 때 커서가 다시 돌아옴.
			}
			@Override
			public void mousePressed(MouseEvent e){ // 마우스가 이미지를 눌렀을 때 이벤트처리
				//Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //마우스 눌렀을 때 소리 재생하게, 반복재생 안하게
				//buttonEnteredMusic.start(); //음악 시작
				selectLeft();
			}
		});
		add(leftButton); //JButton에 버튼 추가됨.
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310,60, 60); // 위치와 크기 정해줌
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter(){ //마우스에 대한 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e){ //마우스가 해당버튼에 올라왔을 때 이벤트처리
				rightButton.setIcon(rightButtonEnteredImage); //rightButton의 아이콘을 rightButtonEnteredImage의 이미지로 바꿔줌
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 올라갔을 때 커서가 손가락 모양으로 바뀜
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);//마우스가 올라갔을 때 소리 재생하게, 반복 안하게
				buttonEnteredMusic.start(); //음악 시작
			}
			@Override
			public void mouseExited(MouseEvent e){ //마우스가 해당버튼에서 나왔을 때 이벤트처리
				rightButton.setIcon(rightButtonBasicImage); //rightButton의 아이콘을 rightButtonBasicImage의 이미지로 바꿔줌
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//마우스가 나왓을 때 커서가 다시 돌아옴.
			}
			@Override
			public void mousePressed(MouseEvent e){ // 마우스가 이미지를 눌렀을 때 이벤트처리
				//Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //마우스 눌렀을 때 소리 재생하게, 반복재생 안하게
				//buttonEnteredMusic.start(); //음악 시작
				selectRight();
			}
		});
		add(rightButton); //JButton에 버튼 추가됨.
		
		menuBar.setBounds(0, 0, 1280, 30); // 위치와 크기를 정해줌
		menuBar.addMouseListener(new MouseAdapter(){ 
			@Override
			public void mousePressed(MouseEvent e){ //마우스로 해당버튼을 눌렀을 떄 이벤트 처리
				mouseX = e.getX(); //이벤트가 발생했을 떄 X, Y 좌표를 얻어온다
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter(){ // 프로그램 창 드래그해서 움직이게 하는 것
			@Override
			public void mouseDragged(MouseEvent e){ //드래그이벤트가 발생했을 때 내용
				int x = e.getXOnScreen(); //현재 스크린의 X, Y좌표를 가져온다.
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); //JFrame의 위치를 바꿔줌
			}
		});
		add(menuBar); // JFrame에 메뉴바가 추가된다.
		
		
	}

	public void paint(Graphics g)//Graphics 라이브러리 오버라이드
	{
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //1280*720 이미지를 screenImage에 넣음
		screenGraphic = screenImage.getGraphics();//screenGraphic은 screenImage를 이용해서 그래픽 객체 얻어옴.
		screenDraw(screenGraphic); // 스크린 그래픽에 그림 그려줌.
		g.drawImage(screenImage,  0 , 0, null); //스크린 이미지를 (0,0)위치에 그려줌
	}
	
	public void screenDraw(Graphics g)//Graphics 라이브러리 오버라이드
	{
		g.drawImage(background, 0, 0, null); //introBackground를 (0,0)에 그려줌. 이미지 화면에 출력할 때 g.drawImage사용
		if(isMainScreen) // 시작화면이 아니라 메인화면일 때 보여질 수 있게 if문 사용
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage,  340,  70,  null);
		}
		paintComponents(g);//이미지를 단순하게 그려주는것 외에 버튼같은것이 추가되면 그려주는 것. 고정된 menuBar나 버튼을 그릴 때 사용함. "add(~)" 이런것들
		this.repaint();//paint함수를 매순간마다 계속 반복되면서 불러옴. 
	}

	public void selectTrack(int nowSelected){ // 현재선택된 곡에 번호를 넣어줌으로써 해당곡이 선택되었음을 알려줌
		if(selectedMusic !=null)
			selectedMusic.close(); //selectedMusic 닫기
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage(); //현재 선택된 곡이 가지고 있는 타이틀 이미지 값을 가져와서 넣어주겠다
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage(); //현재 선택된 곡이 가지고 있는 스타트 이미지 값을 가져와서 넣어주겠다
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true); //현재 선택된 곡을 가져와서 무한 재생함.
		selectedMusic.start();
	}

	public void selectLeft(){
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1; //0번째 곡일 때 왼쪽을 누르면 가장 오른쪽곡이 선택 되어야 하기 때문에
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight(){
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0; 
		else
			nowSelected++;
		selectTrack(nowSelected);
	}

}
