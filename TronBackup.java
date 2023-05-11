import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Random;

/*public class Tron extends JFrame implements ActionListener, KeyListener{
	Timer myTimer;
	GamePanel game=new GamePanel();

    public Tron() {
		super("TRON LEGACY OF THE FALLEN HEROES OF THE NORDIC TRIBE");
		addKeyListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);

		myTimer = new Timer(10, this);	 // trigger every 100 ms
		myTimer.start();

		//game = new GamePanel();
		add(game);

		setResizable(false);
		setVisible(true);

    }

	public void actionPerformed(ActionEvent evt){
		if(game!= null){
			game.direct();
			game.repaint();
		}
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

/*class TronMenu extends JFrame implements ActionListener{
	public TronMenu(){

	}
}*/

/*class GamePanel extends JPanel implements MouseListener{
	private TronRacer player1,player2;
	private int mousex,mousey;
	private boolean[] keys;
	private int[][] boardtrack=new int[160][120];
	Image tronBack,winner,tieGame,invinc,menuBack,spaceToStart;
	public boolean ready=false;
	private boolean gotName=false;
	final static int RIGHT=1;
	final static int LEFT=2;
	final static int UP=3;
	final static int DOWN=4;
	static int player1Move=LEFT;
	static int player2Move=RIGHT;
	static int temp=0;
	static int[] tempArr=new int[4];
	static int[] tempArr2=new int[4];
	static boolean startPos=true;
	static boolean p1Move=false;
	static boolean p2Move=false;
	Random rand = new Random();
	int powerplaced=-1;
	static boolean menuYes=true;
	JButton startBtn = new JButton("START GAME");

	public GamePanel(){
		setLayout(new BorderLayout());
		addMouseListener(this);
		player1=new TronRacer(Color.blue,700,300);
		player2=new TronRacer(Color.red,100,300);
		tronBack=new ImageIcon("tronBack.png").getImage();
		winner=new ImageIcon("congrats.png").getImage();
		invinc=new ImageIcon("invinc.png").getImage();
		//Image winner=winnerPic.getScaledInstance(156,74,Image.SCALE_DEFAULT);
		tieGame=new ImageIcon("tieGame.png").getImage();
		menuBack=new ImageIcon("MENUBACK.jpg").getImage();
		menuBack=menuBack.getScaledInstance(800,600,Image.SCALE_SMOOTH);
		spaceToStart=new ImageIcon("spaceToStart.png").getImage();
		spaceToStart=spaceToStart.getScaledInstance(300,28,Image.SCALE_SMOOTH);
		keys=new boolean[KeyEvent.KEY_LAST+1];
		setSize(800,600);
		tempArr[0]=0;
		tempArr[1]=0;
		tempArr[2]=0;
		tempArr[3]=1;
		player1.setFront(tempArr);
		tempArr2[0]=1;
		tempArr2[1]=0;
		tempArr2[2]=1;
		tempArr2[3]=1;
		player2.setFront(tempArr2);
		//add(game, BorderLayout.CENTER);
		startBtn.setSize(100,30);
		startBtn.setLocation(350,400);
	}

   /* public void addNotify() {
        super.addNotify();
        ready = true;
    }
	public void setKey(int k, boolean v) {
    	keys[k] = v;
    }
    public void direct() {
    	if (player1.getAlive() && player2.getAlive() && menuYes==false){
	    		if (startPos==false){//the first bit of each tron player's line


			    	boardtrack[player1.getTronX()/5][player1.getTronY()/5]=1;
			    	boardtrack[player1.getTronX()/5+1][player1.getTronY()/5]=1;
			    	boardtrack[player1.getTronX()/5][player1.getTronY()/5+1]=1;
			    	boardtrack[player1.getTronX()/5+1][player1.getTronY()/5+1]=1;
					System.out.print(player1.getAlive());
			    	boardtrack[player2.getTronX()/5][player2.getTronY()/5]=1;
			    	boardtrack[player2.getTronX()/5+1][player2.getTronY()/5]=1;
			    	boardtrack[player2.getTronX()/5][player2.getTronY()/5+1]=1;
			    	boardtrack[player2.getTronX()/5+1][player2.getTronY()/5+1]=1;

	    		}
	    	startPos=false;
	    	if (p1Move==false){
				if(keys[KeyEvent.VK_RIGHT] && player1Move!=LEFT){
					player1Move=RIGHT;
					tempArr[0]=1;
					tempArr[1]=0;
					tempArr[2]=1;
					tempArr[3]=1;
					player1.setFront(tempArr);
					p1Move=true;

				}
				else if(keys[KeyEvent.VK_LEFT] && player1Move!=RIGHT){
					player1Move=LEFT;
					tempArr[0]=0;
					tempArr[1]=0;
					tempArr[2]=0;
					tempArr[3]=1;
					player1.setFront(tempArr);
					p1Move=true;

				}
				else if(keys[KeyEvent.VK_UP] && player1Move!=DOWN){
					player1Move=UP;
					tempArr[0]=0;
					tempArr[1]=0;
					tempArr[2]=1;
					tempArr[3]=0;
					player1.setFront(tempArr);
					p1Move=true;


				}
				else if(keys[KeyEvent.VK_DOWN] && player1Move!=UP){
					player1Move=DOWN;
					tempArr[0]=0;
					tempArr[1]=1;
					tempArr[2]=1;
					tempArr[3]=1;
					player1.setFront(tempArr);
					p1Move=true;
				}

	    	}
	    	else{
	    		p1Move=false;
	    	}
	    	if (p2Move==false){
				if(keys[KeyEvent.VK_D] && player2Move!=LEFT){
					player2Move=RIGHT;
					tempArr2[0]=1;
					tempArr2[1]=0;
					tempArr2[2]=1;
					tempArr2[3]=1;
					player2.setFront(tempArr2);
					p2Move=true;

				}
				else if(keys[KeyEvent.VK_A] && player2Move!=RIGHT){
					player2Move=LEFT;
					tempArr2[0]=0;
					tempArr2[1]=0;
					tempArr2[2]=0;
					tempArr2[3]=1;
					player2.setFront(tempArr2);
					p2Move=true;

				}
				else if(keys[KeyEvent.VK_W] && player2Move!=DOWN){
					player2Move=UP;
					tempArr2[0]=0;
					tempArr2[1]=0;
					tempArr2[2]=1;
					tempArr2[3]=0;
					player2.setFront(tempArr2);
					p2Move=true;

				}
				else if(keys[KeyEvent.VK_S] && player2Move!=UP){
					player2Move=DOWN;
					tempArr2[0]=0;
					tempArr2[1]=1;
					tempArr2[2]=1;
					tempArr2[3]=1;
					player2.setFront(tempArr2);
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
    	if (menuYes==false){

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
    }

    public void paintComponent(Graphics g){
    	if (menuYes){
    		g.drawImage(menuBack,0,0,this);
    		//g.drawImage(spaceToStart,250,400,this);


    		if(keys[KeyEvent.VK_SPACE]){
    			menuYes=false;
    		}
    	}
    	else{

	    	if (temp==0){
	    		g.drawImage(tronBack,0,0,this);
	    		temp++;
	    	}
	    	if (player1.getAlive()==true && player2.getAlive()==true){
	    		System.out.println(player2.getTronX());
	    		g.setColor(player1.getTronColor());
	        	g.fillRect(player1.getTronX(),player1.getTronY(),10,10);
	        	g.setColor(player2.getTronColor());
	        	g.fillRect(player2.getTronX(),player2.getTronY(),10,10);
	    	}
	    	else{

	    		if (player1.getAlive()==true && player2.getAlive()==false){
	    			g.drawImage(winner,0,0,this);
	    		}
	    		else if(player2.getAlive()==true && player1.getAlive()==false){
	    			g.drawImage(winner,0,0,this);
	    		}
	    		else if (player1.getAlive()==false && player2.getAlive()==false){

	    			g.drawImage(tieGame,0,0,this);
	    		}
	    	}
    	}
    }
    /*public void tronMenu(Graphics m){
    	m.drawImage(menuBack,0,0,this);
    }
    public void collide(){
    	if (player1.getAlive() && player2.getAlive()){
	    	if (player1.getTronX()<0 || player1.getTronX()>785 || player1.getTronY()<0 || player1.getTronY()>560){
	    		player1.setAlive(false);
	    	}

	    	else if ((boardtrack[(player1.getTronX()/5+player1.getFront()[0])][(player1.getTronY()/5+player1.getFront()[1])]==1 || boardtrack[(player1.getTronX()/5+player1.getFront()[2])][(player1.getTronY()/5+player1.getFront()[3])]==1)&& player1.getInvinc()==false){
	    		player1.setAlive(false);
	    	}
	    	if (player2.getTronX()<0 || player2.getTronX()>785 || player2.getTronY()<0 || player2.getTronY()>560){
	    		player2.setAlive(false);
	    	}
	    	else if ((boardtrack[(player2.getTronX()/5+player2.getFront()[0])][(player2.getTronY()/5+player2.getFront()[1])]==1 || boardtrack[(player2.getTronX()/5+player2.getFront()[2])][(player2.getTronY()/5+player2.getFront()[3])]==1)&& player2.getInvinc()==false){
	    		player2.setAlive(false);
	    	}
    	}
    }




    // ------------ MouseListener ------------------------------------------
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e){}

    public void mousePressed(MouseEvent e){
		/*destx = e.getX();
		desty = e.getY();
		destx -= destx %5;
		desty -= desty %5;
	}

    // ---------- MouseMotionListener ------------------------------------------




}*/