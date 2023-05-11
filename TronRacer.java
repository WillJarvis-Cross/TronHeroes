 import java.awt.*;
public class TronRacer {
 	private boolean alive=true;
 	private int locx,locy,dirX,dirY;
 	private int[] front=new int[4];
 	private Color color=Color.blue;
 	private boolean invincOn=false;

    public TronRacer(Color colorOfLine,int locx,int locy) {
    	color=colorOfLine;
    	System.out.println(locx);
    	this.locx=locx;
    	this.locy=locy;

    	//System.out.println("dd");
    }

    /**
     * @param args the command line arguments
     */
	public int getTronX(){
		//System.out.println(locx);
		return locx;
	}
	public int getTronY(){
		return locy;
	}
	public void setTronX(int x){
		locx=x;
	}
	public void setTronY(int y){
		locy=y;
	}
	public void setAlive(boolean DorA){
		alive=DorA;
	}
	public boolean getAlive(){
		return alive;
	}
	public Color getTronColor(){
		return color;
	}
	public void setFront(int[] dir){
		front=dir;
	}
	public int[] getFront(){
		return front;
	}
	public void setInvinc(boolean invinc){
		invincOn=invinc;
	}
	public boolean getInvinc(){
		return invincOn;
	}
/*	public void setDirX(int dir){
		dirX=dir;
	}
	public void setDirY(int dir){
		dirY=dir;
	}
	public int getDirX(){
		return dirX;
	}
	public int getDirY(){
		return dirY;
	}*/
}
