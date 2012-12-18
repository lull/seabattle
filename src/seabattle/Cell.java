/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seabattle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author me
 */
public class Cell extends JPanel {
    
    public enum CellType {
        DEAD,
        WOUNDED,
        HEALHY,
        EMPTY,
        NONE
    }
    
    int _X=0, _Y=0;
    CellType type = CellType.NONE;
    int indexRow=0, indexColumn=0;


    private Timer time = new Timer(100, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            Cross();
        }
    });

    public Cell(int x, int y) {
        //this.setBackground(Color.red);
        this.setSize(25, 25);
        this.setLocation(x, y);

    }
    
    public Cell(LayoutManager layout, boolean isDoubleBuffered)
    {
        super(layout,isDoubleBuffered);
    }

    public int getIndexRow() {
        return indexRow;
    }

    public int getIndexColumn() {
        return indexColumn;
    }

    public void setIndexColumn(int indexColumn) {
        this.indexColumn = indexColumn;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }


    @Override
    public void repaint()
    {
        super.repaint();
        this.Draw();
    }

    void Draw()
    {
        if (type == CellType.DEAD) {
            DrawCross();
        }
        else if (type == CellType.WOUNDED){
        DrawPoint(); 
        }
        else if (type == CellType.EMPTY){
            DrawRectangle();
        }
        /*
        switch(type)
        {       
            case 1: DrawPoint(); break;
            case 2: DrawRectangle(); break;
            case 3: DrawCross(); break;
            default: break;
        }*/

    }

    void DrawPoint()
    {
        Graphics g = this.getGraphics();

        int x = this.getWidth()/2;
        int y = this.getHeight()/2;

        g.setColor(Color.BLACK);
        g.drawOval(x, y, 4, 4);
    }

    void DrawCross()
    {
        this.time.start();
    }

    void Cross()
    {
        Graphics g = this.getGraphics();

        int x = this.getWidth();
        int y = this.getHeight();

        g.setColor(Color.black);
        g.drawLine(0, 0, x, y);
        g.drawLine(0, y, x, 0);
    }

    void DrawRectangle()
    {
        Graphics g = this.getGraphics();

        int x = this.getWidth();
        int y = this.getHeight();

        g.setColor(Color.BLACK);

        g.drawRect(5, 5, x-10, y-10);
    }

    public void getDef()
    {
        if(time.isRunning()) time.stop();
        this.setBackground(Color.green);
    }

}
