import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class wspolrzedne extends Component implements ActionListener {
    //wspolrzedne x
    private final int pX[][] = {
            //M
            {200, 200, 200, 200},
            {200, 220, 240, 260},
            {260, 300, 340, 360},
            {360, 400, 440, 480},
            {480, 500, 520, 540},
            {540, 540, 540, 540},
            {540, 520, 500, 480},
            {480, 480, 480, 480},
            {480, 440, 400, 360},
            {360, 340, 300, 260},
            {260, 260, 260, 260},
            {260, 240, 220, 200},
            //B
            {700, 700, 700, 700},
            {700, 850, 1000, 1050},
            {1050, 1000, 900, 900},
            {900, 900, 1000, 1050},
            {1050, 1000, 850, 700},

            {800, 800, 800, 800},
            {800, 875, 925, 950},
            {950, 925, 875, 800},

            {800, 800, 800, 800},
            {800, 875, 925, 950},
            {950, 925, 875, 800},

    };
    //wspolrzedne y
    private final int pY[][] = {
            //M
            {100, 600, 600, 600},
            {100, 100, 100, 100},
            {100, 150, 200, 250},
            {250, 200, 150, 100},
            {100, 100, 100, 100},
            {100, 200, 400, 600},
            {600, 600, 600, 600},
            {600, 400, 300, 200},
            {200, 250, 300, 350},
            {350, 300, 250, 200},
            {200, 400, 600, 600},
            {600, 600, 600, 600},
            //B
            {600, 400, 200, 100},
            {600, 600, 635, 450},
            {450, 300, 315, 315},
            {315, 315, 330, 200},
            {200, 100, 95, 100},

            {150, 266, 266, 266},
            {150, 150, 140, 210},
            {210, 276, 266, 266},

            {375, 525, 535, 525},
            {375, 375, 395, 450},
            {450, 535, 525, 525},


    };

    //pisanie
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setColor(Color.BLACK);

        for (int k = 0; k < pX.length; k++){
            for (double t=0.0; t<=1.0; t+=0.0005){
                double tx=(1-t)*(1-t)*(1-t)* pX[k][0]+3*t*(1-t)*(1-t)* pX[k][1]+3*t*t*(1-t)* pX[k][2]+t*t*t* pX[k][3];
                double ty=(1-t)*(1-t)*(1-t)* pY[k][0]+3*t*(1-t)*(1-t)* pY[k][1]+3*t*t*(1-t)* pY[k][2]+t*t*t* pY[k][3];
                int px = (int)tx;
                int py = (int)ty;
                g.drawLine(px,py,px,py);
            }
        }
        g2d.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }
}
//wywolanie funkcji
public class Main extends JFrame {
    public Main() {
        initUI();
    }
    private void initUI() {
        //tworzenie nowego napisu

        add(new wspolrzedne());
        setTitle("PL");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override

            //uruchomienie napisu
            public void run() {
                Main ex = new Main();
                ex.setVisible(true);
            }
        });
    }
}