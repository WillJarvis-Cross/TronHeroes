import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuEg extends JFrame implements ActionListener
{
    JPanel cards;   	//a panel that uses CardLayout
    CardLayout cLayout = new CardLayout();  // I could make this dynamically, then use getLayout
					    //      to get the reference to it, but this is easier.

	JButton playBtn = new JButton("Play");
	Timer myTimer;
	GamePanel gamePage = new GamePanel();
	
    public MenuEg ()
    {
		super ("Menu Eg");
		setSize (800, 600);
		
		playBtn.addActionListener(this);
		myTimer = new Timer(10,this);

		JPanel mPage = new JPanel();                // Main Page - it just a panel
		mPage.setLayout(null);
		
		playBtn.setSize(100,30);
		playBtn.setLocation(350,400);
		add(playBtn);
		
		JLabel inst1 = new JLabel("When using a null layout manager");
		inst1.setSize(200,30);
		inst1.setLocation(350,100);
		add(inst1);
		JLabel inst2 = new JLabel("you need to setSize and setLocation");
		inst2.setSize(280,30);
		inst2.setLocation(350,120);
		add(inst2);
		JLabel inst3 = new JLabel("of everything you add.");
		inst3.setSize(200,30);
		inst3.setLocation(350,140);
		add(inst3);
		
		
		/* THIS IS WHERE THE MAGIC HAPPENS
			This panel will allow us to store the other panels, and show the one we want.
			The panels are being stored (are shown) based on a simple string
		*/
		cards = new JPanel(cLayout);
		cards.add(mPage, "menu");
		cards.add(gamePage, "game");


		add(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible (true);
    }

    public void actionPerformed(ActionEvent evt) {
		Object source =evt.getSource();
		if(source==playBtn){
		    cLayout.show(cards,"game");
		    myTimer.start();
		}
		else if(source==myTimer){
			gamePage.move();
			gamePage.repaint();
		}

    }

    public static void main(String[] args){
		MenuEg menuEg = new MenuEg();
    }
}

/*class GamePanel extends JPanel implements MouseListener{
	private int destx,desty,boxx,boxy;

	public GamePanel(){
		addMouseListener(this);
		boxx=200;
		boxy=200;
		destx=500;
		desty=200;
		setSize(800,600);
	}


    public void move() {
		if(boxx<destx){
			boxx+=5;
		}
		if(boxx>destx){
			boxx-=5;
		}
		if(boxy<desty){
			boxy+=5;
		}
		if(boxy>desty){
			boxy-=5;
		}
    }

    public void paintComponent(Graphics g){
		 g.setColor(new Color(222,222,255));
         g.fillRect(0,0,getWidth(),getHeight());
         g.setColor(new Color(255,111,111));
         g.fillOval(destx,desty,10,10);
         g.setColor(Color.green);
         g.fillRect(boxx,boxy,20,20);


    }

    // ------------ MouseListener ------------------------------------------
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e){}

    public void mousePressed(MouseEvent e){
		destx = e.getX();
		desty = e.getY();
	}

}*/

