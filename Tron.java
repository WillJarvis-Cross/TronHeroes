import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Random;

public class Tron extends JFrame implements ActionListener, KeyListener{
	Timer myTimer;
	GamePanel game=new GamePanel();

    public Tron() {
		super("TRON LEGACY OF THE FALLEN HEROES OF THE NORDIC TRIBE");
		addKeyListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);

		myTimer = new Timer(10, this);	 // trigger every 100 ms
		//myTimer.start();

		//game = new GamePanel();
		add(game);

		setResizable(false);
		setVisible(true);
		new TronMenu(this);
    }

	public void actionPerformed(ActionEvent evt){
		if(game!= null){
			game.direct();
			game.repaint();
		}
	}
	public void start(){
		myTimer.start();
		setVisible(true);
	}
	public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
    	game.setKey(e.getKeyCode(),true);
    }

    public void keyReleased(KeyEvent e) {
    	game.setKey(e.getKeyCode(),false);
    }
    public static void main(String[] arguments) {
		Tron frame = new Tron();
    }
}

class TronMenu extends JFrame implements ActionListener{//This class acts as a menu screen and an instructions screen. 
														//The menu is the first thing the user sees and gives them the 
														//option to look at the instructions or go straight to the game.
	private Tron me3;//A Tron object
	JButton playBtn = new JButton("PLAY");//The play button on the menu and the instructions screen
	JButton instructBtn = new JButton("INSTRUCTIONS");//The instructions button that leads to the instructions screen
	static int menuNum=1;//1 means it is on the menu and 2 means the instruction screen

	public TronMenu(Tron m){//this creates the menu and the instructions screen when needed and it takes in a Tron object
		super ("TRON LEGACY OF THE FALLEN HEROES OF THE NORDIC TRIBE");
		setSize (800, 600);
		me3 = m;
		playBtn.addActionListener(this);
		instructBtn.addActionListener(this);
		ImageIcon back = new ImageIcon("tronImages/MENUBACK.jpg");//background for the menu
		JLabel backLabel = new JLabel(back);//backLabel is the diplay area for the menuback image 
		JLayeredPane mPage=new JLayeredPane();// LayeredPane allows me to control what shows on top
		mPage.setLayout(null);
		backLabel.setSize(800,600);
		backLabel.setLocation(0,0);
		mPage.add(backLabel,1);// The last number controls what's on top
		
		if (menuNum==1){//displaying the menu screen										
			playBtn.setSize(200,60);//adding play button
			playBtn.setLocation(425,400);
			mPage.add(playBtn,0);
			
			instructBtn.setSize(200,60);//adding instructions button
			instructBtn.setLocation(150,400);
			mPage.add(instructBtn,0);
			
			//I got all the following fonts from a website and downloaded the image
			ImageIcon title1 = new ImageIcon("tronImages/tronTitle1.png");//It's a long title so I had to break it up into two 
															   //different images and display the second below the first.
															   //This is the first part 
			JLabel titleLabel1 = new JLabel(title1);
			titleLabel1.setSize(800,40);
			titleLabel1.setLocation(-5,50);
			mPage.add(titleLabel1,0);
			
			ImageIcon title2 = new ImageIcon("tronImages/tronTitle2.png");//this is the second part of the title
			JLabel titleLabel2 = new JLabel(title2);
			titleLabel2.setSize(800,40);
			titleLabel2.setLocation(5,100);
			mPage.add(titleLabel2,0);
		}
		else{//This is for the instructions screen
			playBtn.setSize(200,60);//The play button is still there but its centered now
			playBtn.setLocation(300,420);
			mPage.add(playBtn,0);
			
			ImageIcon instructions = new ImageIcon("tronImages/instructions.png");//This is the title for the instructions screen. It reads, "INSTRUCTIONS".
			JLabel instructionsLabel = new JLabel(instructions);
			instructionsLabel.setSize(800,140);
			instructionsLabel.setLocation(-5,0);
			mPage.add(instructionsLabel,0);
			
			ImageIcon p1Font = new ImageIcon("tronImages/p1Font.png");//This is a text that reads, "PLAYER 1"
			JLabel p1FontLabel = new JLabel(p1Font);
			p1FontLabel.setSize(400,140);
			p1FontLabel.setLocation(-30,220);
			mPage.add(p1FontLabel,0);
			
			ImageIcon p2Font = new ImageIcon("tronImages/p2Font.png");//This is a text that reads, "PLAYER 2"
			JLabel p2FontLabel = new JLabel(p2Font);
			p2FontLabel.setSize(400,140);
			p2FontLabel.setLocation(410,220);
			mPage.add(p2FontLabel,0);
			
			ImageIcon wasd = new ImageIcon("tronImages/wasd.png");//under where it says player 1, a picture of the wasd keys are added to tell the user what keys to use
			JLabel wasdLabel = new JLabel(wasd);
			wasdLabel.setSize(400,190);
			wasdLabel.setLocation(-30,280);
			mPage.add(wasdLabel,0);
			
			ImageIcon arrows = new ImageIcon("tronImages/arrowKeys.png");//under where it says player 2, a picture of the arrow keys are added to tell the user what keys to use
			JLabel arrowsLabel = new JLabel(arrows);
			arrowsLabel.setSize(400,190);
			arrowsLabel.setLocation(410,280);
			mPage.add(arrowsLabel,0);
		}
		add(mPage);//adding the mPage with all the pictures and buttons to the screen
		setVisible(true);//so the user can see the game
	}

    public void actionPerformed(ActionEvent evt) {//I use this to check if one of the buttons was pressed
    	if(evt.getSource()==playBtn){//if they press play
	    	setVisible(false);//the menu is now invisible
			me3.start();//calls a method which starts the tron game
    	}
    	else if(evt.getSource()==instructBtn){//if they press the instructions button
    		menuNum=2;//means the instructions page will be displayed when it gets called
    		new TronMenu(me3);//making a new TronMenu and this time it is the instructions page
    	}
		
    }
}
class GamePanel extends JPanel implements MouseListener{
	private TronRacer player1,player2;
	private boolean[] keys;
	private int[][] boardtrack=new int[160][120];
	Image tronBack,winner,tieGame,invinc,menuBack,spaceToStart, p1Font, p2Font;
	public boolean ready=false;
	final static int RIGHT=1;
	final static int LEFT=2;
	final static int UP=3;
	final static int DOWN=4;
	static int player1Move=RIGHT;
	static int player2Move=LEFT;
	static int temp=0;
	static boolean startPos=true;
	static boolean p1Move=false;
	static boolean p2Move=false;
	static boolean gameOver = false;
	Random rand = new Random();
	int powerplaced=-1;
	static boolean menuYes;
	JButton startBtn = new JButton("START GAME");
	static JLayeredPane mPage;
	

	public GamePanel(){
		mPage=new JLayeredPane();// LayeredPane allows me to control what shows on top
		mPage.setLayout(null);
		setLayout(new BorderLayout());
		addMouseListener(this);
		
		player1=new TronRacer(Color.blue,100,300);
		player2=new TronRacer(Color.red,700,300);
		tronBack=new ImageIcon("tronImages/tronBack.png").getImage();
		winner=new ImageIcon("tronImages/congrats.png").getImage();
		invinc=new ImageIcon("tronImages/invinc.png").getImage();
		tieGame=new ImageIcon("tronImages/tieGame.png").getImage();
		menuBack=new ImageIcon("tronImages/MENUBACK.jpg").getImage();
		p1Font=new ImageIcon("tronImages/p1Font.png").getImage();
		p2Font=new ImageIcon("tronImages/p2Font.png").getImage();

		spaceToStart=new ImageIcon("tronImages/spaceToStart.png").getImage();
		spaceToStart=spaceToStart.getScaledInstance(300,28,Image.SCALE_SMOOTH);
		keys=new boolean[KeyEvent.KEY_LAST+1];
		setSize(800,600);
		int[] startP1 = {1, 0, 1, 1};
		player1.setFront(startP1);
		int[] startP2 = {0, 0, 0, 1};
		player2.setFront(startP2);
		startBtn.setSize(100,30);
		startBtn.setLocation(350,400);
	}
	
	public void reset() {
		int[] startP1 = {1, 0, 1, 1};
		player1.setFront(startP1);
		int[] startP2 = {0, 0, 0, 1};
		player2.setFront(startP2);
		boardtrack=new int[160][120];
		player1.setAlive(true);
		player2.setAlive(true);
		player1.setTronX(100);
		player1.setTronY(300);
		player2.setTronX(700);
		player2.setTronY(300);
		gameOver = false;
		p1Move = false;
		p2Move = false;
		player1Move = RIGHT;
		player2Move = LEFT;
	}

	public void setKey(int k, boolean v) {
    	keys[k] = v;
    }
    public void direct() {
		System.out.println(keys[KeyEvent.VK_RIGHT]);
    	if (gameOver && keys[KeyEvent.VK_SPACE]) {
			reset();
		}
    	if (player1.getAlive() && player2.getAlive()){
			if (startPos==false){//the first bit of each tron player's line


				boardtrack[player1.getTronX()/5][player1.getTronY()/5]=1;
				boardtrack[player1.getTronX()/5+1][player1.getTronY()/5]=1;
				boardtrack[player1.getTronX()/5][player1.getTronY()/5+1]=1;
				boardtrack[player1.getTronX()/5+1][player1.getTronY()/5+1]=1;

				boardtrack[player2.getTronX()/5][player2.getTronY()/5]=2;
				boardtrack[player2.getTronX()/5+1][player2.getTronY()/5]=2;
				boardtrack[player2.getTronX()/5][player2.getTronY()/5+1]=2;
				boardtrack[player2.getTronX()/5+1][player2.getTronY()/5+1]=2;

			}
	    	startPos=false;
	    	if (p1Move==false){
				if(keys[KeyEvent.VK_D] && player1Move!=LEFT){
					player1Move=RIGHT;
					int[] arr = {1, 0, 1, 1};
					player1.setFront(arr);
					p1Move=true;

				}
				else if(keys[KeyEvent.VK_A] && player1Move!=RIGHT){
					player1Move=LEFT;
					int[] arr = {0, 0, 0, 1};
					player1.setFront(arr);
					p1Move=true;
				}
				else if(keys[KeyEvent.VK_W] && player1Move!=DOWN){
					player1Move=UP;
					int[] arr = {0, 0, 1, 0};
					player1.setFront(arr);
					p1Move=true;
				}
				else if(keys[KeyEvent.VK_S] && player1Move!=UP){
					player1Move=DOWN;
					int[] arr = {0, 1, 1, 1};
					player1.setFront(arr);
					p1Move=true;
				}

	    	}
	    	else{
	    		p1Move=false;
	    	}
	    	if (p2Move==false){
				if(keys[KeyEvent.VK_DOWN] && player2Move!=LEFT){
					player2Move=RIGHT;
					int[] arr = {1, 0, 1, 1};
					player2.setFront(arr);
					p2Move=true;

				}
				else if(keys[KeyEvent.VK_LEFT] && player2Move!=RIGHT){
					player2Move=LEFT;
					int[] arr = {0, 0, 0, 1};
					player2.setFront(arr);
					p2Move=true;

				}
				else if(keys[KeyEvent.VK_UP] && player2Move!=DOWN){
					player2Move=UP;
					int[] arr = {0, 0, 1, 0};
					player2.setFront(arr);
					p2Move=true;

				}
				else if(keys[KeyEvent.VK_RIGHT] && player2Move!=UP){
					player2Move=DOWN;
					int[] arr = {0, 1, 1, 1};
					player2.setFront(arr);
					p2Move=true;

				}

	    	}
	    	else{
	    		p2Move=false;
	    	}
	    	if (keys[KeyEvent.VK_E]){
	    		player2.setInvinc(true);
	    	}
	    	if (keys[KeyEvent.VK_CONTROL]){
	    		player1.setInvinc(true);
	    	}

			move();

	    	collide();
    	}

    }
    public void move(){
		if (player1Move==RIGHT){
			player1.setTronX(player1.getTronX()+5);
		}
		else if (player1Move==LEFT){
			player1.setTronX(player1.getTronX()-5);
		}
		else if (player1Move==UP){
			player1.setTronY(player1.getTronY()-5);
		}
		else if (player1Move==DOWN){
			player1.setTronY(player1.getTronY()+5);
		}
		if (player2Move==RIGHT){
			player2.setTronX(player2.getTronX()+5);
		}
		else if (player2Move==LEFT){
			player2.setTronX(player2.getTronX()-5);
		}
		else if (player2Move==UP){
			player2.setTronY(player2.getTronY()-5);
		}
		else if (player2Move==DOWN){
			player2.setTronY(player2.getTronY()+5);
		}
    }

    public void paintComponent(Graphics g){

	    if (temp==2){

	    	g.drawImage(tronBack,0,0,this);
	    	temp++;

	    }
	    else if (temp>2){
			g.drawImage(tronBack,0,0,this);
			for (int i = 0; i < boardtrack.length; i++) {
				for (int j = 0; j < boardtrack[i].length; j++) {
					if (boardtrack[i][j] > 0) {
						g.setColor(boardtrack[i][j] == 1 ? player1.getTronColor() : player2.getTronColor());
						g.fillRect(i*5,j*5,10,10);
					}
				}
			}
		    if (!gameOver){
		    	g.setColor(player1.getTronColor());
		       	g.fillRect(player1.getTronX(),player1.getTronY(),10,10);
		       	g.setColor(player2.getTronColor());
		       	g.fillRect(player2.getTronX(),player2.getTronY(),10,10);
		    }
		    else{
				g.drawImage(spaceToStart, 260, 0, this);
		    	if (player1.getAlive() && !player2.getAlive()){
		    		g.drawImage(winner,166,150,this);
					g.drawImage(p1Font,279,400,this);
		    	}
		    	else if(player2.getAlive() && !player1.getAlive()){
		    		g.drawImage(winner,166,150,this);
					g.drawImage(p2Font,279,400,this);
		    	}
		    	else {
		    		g.drawImage(tieGame,150,232,this);
		    	}
		    }
	    }
	    temp++;
    }
    public void collide(){
		if (player1.getTronX()<0 || player1.getTronX()>785 || player1.getTronY()<0 || player1.getTronY()>560){
			player1.setAlive(false);
			gameOver = true;
		}
		else if ((boardtrack[(player1.getTronX()/5+player1.getFront()[0])][(player1.getTronY()/5+player1.getFront()[1])]==1 || boardtrack[(player1.getTronX()/5+player1.getFront()[2])][(player1.getTronY()/5+player1.getFront()[3])]==1)&& player1.getInvinc()==false){
			player1.setAlive(false);
			gameOver = true;
		}
		if (player2.getTronX()<0 || player2.getTronX()>785 || player2.getTronY()<0 || player2.getTronY()>560){
			player2.setAlive(false);
			gameOver = true;
		}
		else if ((boardtrack[(player2.getTronX()/5+player2.getFront()[0])][(player2.getTronY()/5+player2.getFront()[1])]==1 || boardtrack[(player2.getTronX()/5+player2.getFront()[2])][(player2.getTronY()/5+player2.getFront()[3])]==1)&& player2.getInvinc()==false){
			player2.setAlive(false);
			gameOver = true;
		}
    }

    // ------------ MouseListener ------------------------------------------
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
	/*public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==playAgainBtn){//if they press the instructions button
			//new Tron();//means the instructions page will be displayed when it gets called
			//reset();
		} else if (evt.getSource() == menuBtn) {
			reset();
			new Tron();//making a new TronMenu and this time it is the instructions page
		}
	}*/
}