/**
 * @(#)test.java
 *
 *
 * @author 
 * @version 1.00 2017/10/3
 */
import java.util.*;
public class Block {
	private int blockx,blocky,size;
    public Block(int x,int y,int s) {
    	blockx=x;
    	blocky=y;
    	size=s;
    }
    
    /**
     * @param args the command line arguments
     */
    public int getBlockx(){
    	return blockx;
    }
    public int getBlocky(){
    	return blocky;
    }
    public int getSize(){
    	return size;
    }
    	
    public boolean collidepoint(int xc,int yc){
    	if (blockx<=xc&&xc<=blockx+size&&blocky<=yc&&yc<=blocky+size){
    		return true;
    	}
    	return false;
    }
}
