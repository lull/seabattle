/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seabattle;

import java.util.Collection;

public class Ship {

   /*public enum ShipType {
        FOUR,
        THREE,
        TWO,
        ONE
       }*/
    public byte ShipType;
    
    public enum Rotation {
        HORIZONTAL,
        VERTICAL
    }

    private byte type;
    private Rotation rotation;
    private byte life;
    


    private char x, y;  //x&y of head
	//private Collection<Deck> decks;

    public Ship() {
        rotation = Rotation.VERTICAL;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public void setType(byte type) {
        this.type = type;
        this.life = type;
    }

    public byte getType() {
        return type;
    }

    public void Rotate()
    {
        if(rotation == Rotation.VERTICAL) rotation = Rotation.HORIZONTAL;
        else if(rotation == Rotation.HORIZONTAL) rotation = Rotation.VERTICAL;
    }

    public char getX() {
        return x;
    }

    public char getY() {
        return y;
    }

    public void setX(char x) {
        this.x = x;
    }

    public void setY(char y) {
        this.y = y;
    }

    public int getLife() {
        return life;
    }

    public void setLife(byte life) {
        this.life = life;
    }

	public boolean isDead() {
		if (life > 0)
			return true;
		else
			return false;
	}

//	public Collection<Deck> getDecks() {
//		return decks;
//	}

}
