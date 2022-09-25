import java.awt.*;
import java.awt.event.*;
// import java.applet.*;


public class DrawFace extends Frame implements ActionListener, Runnable{
    int k=0;
    Button btn1,btn2;
    Thread th;
    DrawFace(){
        btn1 = new Button("Start");
        btn2 = new Button("Stop");
        setLayout(null);
        btn1.setBounds(40,250,50,20);
        btn2.setBounds(130,250,50,20);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        add(btn1);
        add(btn2);
    }
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        if(o == btn1){
            k=1;
            // repaint();
            th = new Thread(this);
            th.start();
        }
        if(o == btn2){
            k=-1;
            // repaint();
            th.stop();
        }
    }
    public void run(){
        while(k>0){
            System.out.println(k);
            System.out.flush();
            repaint();
           try{
                th.sleep(900);
            }
            catch(Exception e){}
            k++;
            
        }
    }
    
    public void paint(Graphics g){

        //Face
        g.setColor(Color.yellow);
        g.fillOval(40,45,130,150);
        g.setColor(Color.black);
        g.drawOval(40,45,130,150);
        //Eyes
        g.setColor(Color.white);
        g.fillOval(61,82,30,20);   //   x=x+4, y=y+2
        g.fillOval(116,82,30,20);  //   x=x+6, y=y+2
        g.setColor(Color.black);
        g.drawOval(61,82,30,20);   //   x=x+4, y=y+2
        g.drawOval(116,82,30,20);
        //Nose
        g.drawOval(89,108,30,30);
        

                if(k%2==0){
                    System.out.flush();
                    //Hair
                    g.fillArc(60,34,91,65,360,180);
                    
                    //Eye Balls
                    g.fillOval(71,88,10,10);
                    g.fillOval(127,88,10,10);
                    //Moustache
                    g.fillArc(65,142,80,10,360,180);

                    //Mouth
                    g.setColor(Color.white);
                    g.fillArc(65,135,80,35,180,180);
                    g.setColor(Color.black);
                    g.drawArc(65,135,80,35,180,180);
                    g.drawLine(65,152,145,152);
                    g.drawLine(75,152,75,163);
                    g.drawLine(85,152,85,167);
                    g.drawLine(95,152,95,169);
                    g.drawLine(105,152,105,170);
                    g.drawLine(115,152,115,169);
                    g.drawLine(125,152,125,167);
                    g.drawLine(135,152,135,163);

                    // g.drawLine(65,152,145,147);
                    // g.drawLine(65,152,145,147);
                    // g.drawLine(65,152,145,147);

                    //Ears
                    g.setColor(Color.yellow);
                    g.fillOval(25,97,15,30);
                    g.fillOval(170,97,15,30);
                    g.setColor(Color.black);
                    g.drawOval(25,97,15,30);
                    g.drawOval(170,97,15,30);
                }
                else{
                    System.out.flush();            

                    //Eye Balls
                    g.fillOval(68,86,10,10);
                    g.fillOval(124,86,10,10);
                    //Moustache
                    g.fillArc(65,142,80,10,360,180);
                    // g.fillArc(65,145,80,6,180,180);
                    //Mouth
                    g.setColor(Color.white);
                    g.fillOval(95,150,20,20);
                    g.setColor(Color.black);
                    g.drawOval(95,150,20,20);

                    //Ears
                    g.setColor(Color.yellow);
                    g.fillOval(28,97,12,30);
                    g.fillOval(170,97,12,30);
                    g.setColor(Color.black);
                    g.drawOval(28,97,12,30);
                    g.drawOval(170,97,12,30);
                }
                


    }
    public static void main(String args[]){
        DrawFace d = new DrawFace();
        d.setSize(400,400);
        d.setVisible(true);
    }
}
