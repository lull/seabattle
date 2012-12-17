/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seabattle;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

public class AI {

    char Ships[][] = new char[11][11];
    char virtShips[][] = new char[11][11];
    private Ship settedShip = new Ship();
    public int counterOfShips = 0;
    private ArrayList<Ship> listShip = new ArrayList<Ship>();

    public AI() {
        for(int i=0;i<11;i++)
            for(int j=0;j<11;j++)
                Ships[i][j]=0;
        listShip.clear();
        counterOfShips = 0;
    }

    public void getDefault()
    {
        for(int i=0;i<11;i++)
            for(int j=0;j<11;j++)
                Ships[i][j]=0;
        listShip.clear();
        counterOfShips = 0;
    }

    // <editor-fold defaultstate="collapsed" desc="Logic">
    public void setShips() {
        counterOfShips = 0;
        int x = 100, y = 100;

        do {
            do {
                //check if collide than new location
                do {
                    //chose header cell for ship
                    Random a = new Random();
                    Random b = new Random();
                    x = 1 + a.nextInt(9);
                    y = 1 + b.nextInt(9);
                    int aa = a.nextInt(10);

                    if (aa > 5) {
                        settedShip.setRotation(Ship.Rotation.VERTICAL);

                    } else {
                        settedShip.setRotation(Ship.Rotation.HORIZONTAL);
                    }
                } while (checkFillable(x, y) != 0);
            } while (checkCollide(x, y) != 0);
            setShip(x, y, settedShip);
        } while (counterOfShips < 10);
    }

    private int checkFillable(int x, int y) {
        //задать тип корабля
        giveTypeShip();

        int numCell = settedShip.getType(); // количество клеток у корабля
        Ship.Rotation direction = settedShip.getRotation();  //поворот корабля

        //virtShips = Ships.clone();
        
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                virtShips[j][i] = Ships[j][i];
            }

        }
        
        if (direction == Ship.Rotation.VERTICAL) //если направление вниз
        {
            try {
                for (int i = 0; i < numCell; i++) {
                    virtShips[x][y + i] = 1;

                }
            } catch (Exception e) {
                return 1;
            }
        }

        if (direction == Ship.Rotation.HORIZONTAL) {
            try {
                for (int i = 0; i < numCell; i++) {
                    virtShips[x + i][y] = 1;

                }
            } catch (Exception e) {
                return 1;
            }
        }
        return 0;
    }

    private int checkCollide(int x, int y) {
        int cellNumber = (int) settedShip.getType();
        Ship.Rotation direction = settedShip.getRotation();

        if (direction == Ship.Rotation.VERTICAL) {
            try {
                for (int i = 0; i < cellNumber; i++) //check fill
                {
                    if (Ships[x][y + i] != 0) {
                        return 1;

                    }
                }


                for (int i = -1; i < cellNumber + 1; i++)//right side
                {
                    if (Ships[x + 1][y + i] != 0) {
                        return 1;


                    }

                }
            } catch (Exception e) {

            }

            try {
                for (int i = -1; i < cellNumber + 1; i++)//left side
                {
                    if (Ships[x - 1][y + i] != 0) {
                        return 1;

                    }

                }
            } catch (Exception e) {

            }

            try {
                for (int i = -1; i < 2; i++)//top side
                {
                    if (Ships[x + i][y - 1] != 0) {
                        return 1;

                    }

                }
            } catch (Exception e) {

            }

            try {
                for (int i = -1; i < 2; i++)//down side
                {
                    if (Ships[x + i][y + cellNumber] != 0) {
                        return 1;

                    }

                }
            } catch (Exception e) {

            }

        }
        if (direction == Ship.Rotation.HORIZONTAL) {
            try {

                for (int i = 0; i < cellNumber; i++) //check fill
                {
                    if (Ships[x + i][y] != 0) {
                        return 1;

                    }
                }

                for (int i = -1; i < cellNumber + 1; i++)//top side
                {
                    if (Ships[x + i][y + 1] != 0) {
                        return 1;

                    }

                }
            } catch (Exception e) {

            }

            try {
                for (int i = -1; i < cellNumber + 1; i++)//down side
                {
                    if (Ships[x + i][y - 1] != 0) {
                        return 1;

                    }

                }
            } catch (Exception e) {

            }

            try {
                for (int i = -1; i < 2; i++)//left side
                {
                    if (Ships[x - 1][y + i] != 0) {
                        return 1;

                    }

                }
            } catch (Exception e) {

            }

            try {
                for (int i = -1; i < 2; i++)//right side
                {
                    if (Ships[x + cellNumber][y + i] != 0) {
                        return 1;

                    }

                }
            } catch (Exception e) {

            }

        }
        return 0;
    }

    private void nextShip() {
        switch (counterOfShips) {
            case 0:
                settedShip.setType((byte) 4);
                counterOfShips++;
                break;
            case 1:
                settedShip.setType((byte) 3);
                counterOfShips++;
                break;
            case 2:
                settedShip.setType((byte) 3);
                counterOfShips++;
                break;
            case 3:
                settedShip.setType((byte) 2);
                counterOfShips++;
                break;
            case 4:
                settedShip.setType((byte) 2);
                counterOfShips++;
                break;
            case 5:
                settedShip.setType((byte) 2);
                counterOfShips++;
                break;
            case 6:
                settedShip.setType((byte) 1);
                counterOfShips++;
                break;
            case 7:
                settedShip.setType((byte) 1);
                counterOfShips++;
                break;
            case 8:
                settedShip.setType((byte) 1);
                counterOfShips++;
                break;
            case 9:
                settedShip.setType((byte) 1);
                counterOfShips++;
                break;
            default:
                break;
        }
    }

    private void giveTypeShip() {
        switch (counterOfShips) {
            case 0:
                settedShip.setType((byte) 4);
                break;
            case 1:
                settedShip.setType((byte) 3);
                break;
            case 2:
                settedShip.setType((byte) 3);
                break;
            case 3:
                settedShip.setType((byte) 2);
                break;
            case 4:
                settedShip.setType((byte) 2);
                break;
            case 5:
                settedShip.setType((byte) 2);
                break;
            case 6:
                settedShip.setType((byte) 1);
                break;
            case 7:
                settedShip.setType((byte) 1);
                break;
            case 8:
                settedShip.setType((byte) 1);
                break;
            case 9:
                settedShip.setType((byte) 1);
                break;
            default:
                break;
        }
    }// </editor-fold>

    public ArrayList<Ship> getListShip() {
        return listShip;
    }

    public void loadShips(char arrShips[][])
    {
        for(int i=0;i<11;i++)
            for(int j=0;j<11;j++)
                Ships[i][j] = arrShips[i][j];

        //this.Ships
    }

    public void setListShip(ArrayList<Ship> listShip) {
        this.listShip = listShip;
    }

    private void setShip(int x, int y, Ship sh)
    {
        
        nextShip();
        int _x = (int)x, _y = (int)y;

        int numberCell = 1;

        switch(sh.getType())
        {
            case 1: numberCell = 1;break;
            case 2: numberCell = 2;break;
            case 3: numberCell = 3;break;
            case 4: numberCell = 4;break;
            default: break;
        }
        
        settedShip.setX((char)_x);
        settedShip.setY((char)_y);

        if(sh.getRotation() == Ship.Rotation.VERTICAL)
        {
            for(int i=0;i<numberCell;i++)
                Ships[_x][_y+i] = 1;
        }
        else
        {
            for(int i=0;i<numberCell;i++)
                Ships[_x+i][_y] = 1;
        }
        Ship added = new Ship();

        added.setType(settedShip.getType());
        added.setRotation(settedShip.getRotation());
        added.setX(settedShip.getX());
        added.setY(settedShip.getY());

        listShip.add(added);
        //JOptionPane.showMessageDialog(null, "X:"+_x+" Y:"+_y+" Count:"+numberCell);
    }


    public char[][] getShips() {
        return Ships;
    }

    public Dimension Attack(char[][] field)
    {
        int size = field.length;

        Random a = new Random();
        Random b = new Random();
        int x = 1+a.nextInt(10);
        int y = 1+a.nextInt(10);
        
        return new Dimension(x,y);
    }

  /*  public void WriteShips() throws Exception
    {
        RandomAccessFile raf = new RandomAccessFile("data.txt", "rw");

        String ent = "\n";
        for(int i=0;i<11;i++)
        {
            for(int j=0;j<11;j++)
                raf.writeBytes((int)Ships[i][j]+" ");
            raf.writeBytes(ent);
        }
        raf.close();
    }*/

}
