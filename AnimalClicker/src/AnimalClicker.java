import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.sound.sampled.*;
import javax.swing.*;

import java.net.MalformedURLException;
import java.net.URL;

public class AnimalClicker implements ActionListener{

    int Money = 0;
    boolean first_click_cow = false;
    boolean first_click_pig = false;
    boolean first_click_sheep = false;
    boolean first_click_goat = false;
    boolean first_click_horse = false;
    boolean first_win = false;

    SoundEffect se = new SoundEffect();
    URL pigSound; String chickenSound,cowSound,sheepSound,horseSound,goatSound;
    String BGM;
    String fireworkSound;
    static Clip clip;

    JLabel Count;
    JFrame Frame;
    JPanel Backdrop;
    JPanel CenterPanel;
    JPanel A;
    JPanel B;
    JPanel C;
    JPanel D;
    JPanel E;
    JButton God_button;
    JButton Button;
    Graphics pict;
    BufferedImage img;
    BufferedImage img2;
    BufferedImage img3;
    BufferedImage img4;
    BufferedImage img5;
    BufferedImage img6;
    Image newImage;
    ImageIcon Pig;
    JButton Cow_Button;
    JButton Chicken_Button;
    JButton Pig_Button;
    JButton Sheep_Button;
    JButton Goat_Button;
    JButton Horse_Button;
//    JButton Win_Button;

    //Constructor
    public AnimalClicker() throws MalformedURLException {
        Frame=new JFrame("Animal Clicker");
        Backdrop=new JPanel();
        Count=new JLabel("$0");
        try {
            img = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));
        } catch(IOException ex) {
            System.out.println(ex);
        }

        Chicken_Button = new JButton("+1");
        try {
            Image img2 = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));
            img2 = img2.getScaledInstance( 50, 50, java.awt.Image.SCALE_SMOOTH );
            Chicken_Button.setIcon(new ImageIcon(img2));
        } catch(IOException ex) {
            System.out.println(ex);
        }

        //Cw_Button = new JButton("+5");
        //try {
        //Image img3 = ImageIO.read(new File("/Users/sxfllwm/Desktop/Cow.png"));
        // img3 = img3.getScaledInstance( 50, 50, java.awt.Image.SCALE_SMOOTH );
        //Cw_Button.setIcon(new ImageIcon(img3));
        //} catch(IOException ex) {
        //System.out.println(ex);

//}
        Cow_Button = new JButton("+5");
        try {
            Image img = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));
            img = img.getScaledInstance( 50, 50, java.awt.Image.SCALE_SMOOTH );
            Cow_Button.setIcon(new ImageIcon(img));
        } catch(IOException ex) {
            System.out.println(ex + " here to debug");
        }
        Pig_Button = new JButton("+10");
        try {
            Image img = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));
            img = img.getScaledInstance( 50, 50, java.awt.Image.SCALE_SMOOTH );
            Pig_Button.setIcon(new ImageIcon(img));
        } catch(IOException ex) {
            System.out.println(ex + " here to debug again");
        }
        Sheep_Button = new JButton("+20");
        try {
            Image img = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));
            img = img.getScaledInstance( 50, 50, java.awt.Image.SCALE_SMOOTH );
            Sheep_Button.setIcon(new ImageIcon(img));
        } catch(IOException ex) {
            System.out.println(ex);
        }
        Goat_Button = new JButton("+50");
        try {
            Image img = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));
            img = img.getScaledInstance( 50, 50, java.awt.Image.SCALE_SMOOTH );
            Goat_Button.setIcon(new ImageIcon(img));
        } catch(IOException ex) {
            System.out.println(ex);
        }
        Horse_Button = new JButton("+ 100");
        try {
            Image img = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));
            img = img.getScaledInstance( 50, 50, java.awt.Image.SCALE_SMOOTH );
            Horse_Button.setIcon(new ImageIcon(img));
        } catch(IOException ex) {
            System.out.println(ex);
        }

//        Win_Button = new JButton("Win!");  // added
//        try {
//            Image img = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));
//            img = img.getScaledInstance( 50, 50, java.awt.Image.SCALE_SMOOTH );
//            Win_Button.setIcon(new ImageIcon(img));
//        } catch(IOException ex) {
//            System.out.println(ex);
//        }


        try {
            img2 = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));  // Chicken.png
        } catch(IOException e) {
            System.out.println(e);
        }

        try {
            img3 = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));  // Cow.png
        } catch(IOException e) {
            System.out.println(e);
        }
        try {
            img4 = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));  // Sheep.png
        } catch(IOException e) {
            System.out.println(e);
        }
        try {
            img5 = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));  // Goat.png
        } catch(IOException e) {
            System.out.println(e);
        }
        try {
            img6 = ImageIO.read(new File("/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworks.png"));  // Horse.png
        } catch(IOException e) {
            System.out.println(e);
        }
        God_button=new JButton("+100");
        Chicken_Button.addActionListener(this);
        Cow_Button.addActionListener(this);
        Pig_Button.addActionListener(this);
        Sheep_Button.addActionListener(this);
        Goat_Button.addActionListener(this);
        Horse_Button.addActionListener(this);
//        Win_Button.addActionListener(this);

        CenterPanel = new JPanel() {
            @Override
            protected void paintComponent (Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, 100, 100, this );
//g.setColor(Color.RED);
//g.fillRect(0, 0, 50, 30);
            }
            @Override
            public Dimension getPreferredSize () {
                return new Dimension (100, 100);
            }
        };
        A = new JPanel() {
            @Override
            protected void paintComponent (Graphics g) {
                super.paintComponent(g);
                g.drawImage(img2, 0, 0, 100, 100, this);
//g.setColor(Color.RED);
//g.fillRect(0, 0, 50, 30);
            }
            @Override
            public Dimension getPreferredSize () {
                return new Dimension (100, 100);
            }
        };
        B = new JPanel() {
            @Override
            protected void paintComponent (Graphics g) {
                super.paintComponent(g);
                g.drawImage(img3, 0, 0, 100, 100, this);
//g.setColor(Color.RED);
//g.fillRect(0, 0, 50, 30);
            }
            @Override
            public Dimension getPreferredSize () {
                return new Dimension (100, 100);
            }
        };
        C = new JPanel() {
            @Override
            protected void paintComponent (Graphics g) {
                super.paintComponent(g);
                g.drawImage(img4, 0, 0, 100, 100, this);
//g.setColor(Color.RED);
//g.fillRect(0, 0, 50, 30);
            }
            @Override
            public Dimension getPreferredSize () {
                return new Dimension (100, 100);
            }
        };
        D = new JPanel() {
            @Override
            protected void paintComponent (Graphics g) {
                super.paintComponent(g);
                g.drawImage(img5, 0, 0, 100, 100, this);
//g.setColor(Color.RED);
//g.fillRect(0, 0, 50, 30);
            }
            @Override
            public Dimension getPreferredSize () {
                return new Dimension (100, 100);
            }
        };
        E = new JPanel() {
            @Override
            protected void paintComponent (Graphics g) {
                super.paintComponent(g);
                g.drawImage(img6, 0, 0, 100, 100, this);
//g.setColor(Color.RED);
//g.fillRect(0, 0, 50, 30);
            }
            @Override
            public Dimension getPreferredSize () {
                return new Dimension (100, 100);
            }
        };
        Backdrop.setBorder(BorderFactory.createEmptyBorder(0, 0, 1000, 1000));
        Backdrop.setBounds(750, 750, 100, 100);
//Backdrop.setLayout(new GridLayout(0,1));
//CenterPanel.paintComponents(pict);
        Backdrop.add(Chicken_Button);
        Backdrop.add(Cow_Button);
        Backdrop.add(Pig_Button);
        Backdrop.add(Sheep_Button);
        Backdrop.add(Goat_Button);
        Backdrop.add(Horse_Button);
//        Backdrop.add(Win_Button);
        Backdrop.add(Count);

        Frame.setBackground(Color.blue);


        A.setBounds(400, 300, 200, 200);
        B.setBounds(600, 300, 200, 200);
        CenterPanel.setBounds(800, 300, 100, 100);
        C.setBounds(400, 550, 200, 200);
        D.setBounds(600, 550, 200, 200);
        E.setBounds(800, 550, 200, 200);
//Pig_Button.setBounds(750, 750, 500, 200);
//Backdrop.setBounds(200, 200, 1000, 1000);
        Frame.add(CenterPanel);
        Frame.add(A);
        Frame.add(B);
        Frame.add(C);
        Frame.add(D);
        Frame.add(E);
        Frame.add(Backdrop);
//Frame.add(Backdrop,BorderLayout.CENTER);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setTitle("Animal Clicker");
        Frame.pack();
        Frame.setVisible(true);


        // To add sound:
        pigSound = new URL("http://www.guineapigs-online.com/sounds/futter.wav");
        chickenSound = ".//resource//rooster-crowing.wav";
        cowSound = ".//resource//cow-moo.wav";
        sheepSound = ".//resource//sheep-bleating.wav";
        horseSound = "...";
        goatSound = "...";
        // BGM = ".//resource//Hay_Day_BGM.wav";  // mp3 format does not work
        BGM = "/Users/yutingchai/IdeaProjects/AnimalClicker/resource/Hay_Day_BGM.wav";
        fireworkSound = "/Users/yutingchai/IdeaProjects/AnimalClicker/resource/fireworkSound.wav";  // added
        se.playMusicLocal(BGM, true);  // Sound loops on true. se is of kind SoundEffect.

        /*Pig_Button.addActionListener(new ButtonHandler());
        Chicken_Button.addActionListener(new ButtonHandler());
        Sheep_Button.addActionListener(new ButtonHandler());
        Goat_Button.addActionListener(new ButtonHandler());
        Cow_Button.addActionListener(new ButtonHandler());
        Horse_Button.addActionListener(new ButtonHandler()); */
    }


    public static void main(String[] args) throws MalformedURLException {
        new AnimalClicker();
    }


    //// an inner class for creating sounds
    // From website https://www.youtube.com/watch?v=TErboGLHZGA - How to Play, Loop, Pause and Stop Music in Java
    public static class SoundEffect {
        public void playMusicURL(URL filePath, boolean isBGM) {
            try {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(filePath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                if (isBGM) clip.loop(Clip.LOOP_CONTINUOUSLY);

//                Resume and stop the BGM:
//                JOptionPane. showMessageDialog(null, "Hit ok to pause");
//                long clipTimePosition = clip.getMicrosecondPosition();
//                clip.stop();
//                JOptionPane. showMessageDialog(null, "Hit ok to resume") ;
//                clip.setMicrosecondPosition(clipTimePosition);
//                clip.start();
//                if (isBGM) clip.loop(Clip.LOOP_CONTINUOUSLY);

//                JOptionPane.showMessageDialog(null, "press okay to stop playing.");
//                clip.stop();

            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }

        public void playMusicLocal(String filePath, boolean isBGM) {
            try {
                File soundFile = new File(filePath);
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundFile);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                if (isBGM) clip.loop(Clip.LOOP_CONTINUOUSLY);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

/*
    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Pig_Button)
                //se.playMusicURL(pigSound, false);
            if (e.getSource() == Chicken_Button)
                //se.playMusicLocal(chickenSound, false);
            if (e.getSource() == Sheep_Button)
                se.playMusicLocal(sheepSound, false);
            if (e.getSource() == Cow_Button)
                se.playMusicLocal(cowSound, false);
            if (e.getSource() == Goat_Button)
                se.playMusicLocal(goatSound, false);
            if (e.getSource() == Horse_Button)
                se.playMusicLocal(horseSound, false);
        }
    }
 */


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Chicken_Button) {
//            se.playMusicLocal(chickenSound, false);  // play music when button is clicked
            Money+=1000;
            Count.setText("$" + Money);
        }
        // MAKE THE ELSE-IFS PARALLEL (more reasonable), NOT NESTED.
        else if (e.getSource() == Cow_Button) {
            if (!first_click_cow && Money >= 50) {
//                se.playMusicLocal(cowSound, false);  // play music when button is clicked
                Money -= 50;
                first_click_cow = true;
                Count.setText("$" + Money);
            } else if (first_click_cow) {
//                se.playMusicLocal(cowSound, false);
                Money += 5;
                Count.setText("$" + Money);
            }
        } else if (e.getSource() == Pig_Button) {
            if (!first_click_pig && Money >= 200) {
//            se.playMusicURL(pigSound, false);
                Money -= 200;
                first_click_pig = true;
                Count.setText("$" + Money);
            } else if (first_click_pig) {
//            se.playMusicURL(pigSound, false);
                Money += 10;
                Count.setText("$" + Money);
            }
        } else if (e.getSource() == Sheep_Button) {
            if (!first_click_sheep && Money >= 500) {
//            se.playMusicLocal(sheepSound, false);
                Money -= 500;
                first_click_sheep = true;
                Count.setText("$" + Money);
            } else if (first_click_sheep) {
//            se.playMusicLocal(sheepSound, false);
                Money += 20;
                Count.setText("$" + Money);
            }
        } else if (e.getSource() == Goat_Button) {
            if (!first_click_goat && Money >= 1000) {
//            se.playMusicLocal(goatSound, false);
                Money -= 1000;
                first_click_goat = true;
                Count.setText("$" + Money);
            } else if (first_click_goat) {
//            se.playMusicLocal(goatSound, false);
                Money += 50;
                Count.setText("$" + Money);
            }
        } else if (e.getSource() == Horse_Button) {
            if (!first_click_horse && Money >= 2000) {
//            se.playMusicLocal(horseSound, false);
                Money -= 2000;
                first_click_horse = true;
                Count.setText("$" + Money);
            } else if (first_click_horse) {
//            se.playMusicLocal(horseSound, false);
                Money += 100;
                Count.setText("$" + Money);
            }
        } /*else if (e.getSource() == Win_Button) {
            clip.stop();
            se.playMusicLocal(fireworkSound, true);
            JOptionPane.showMessageDialog(null, "Congrats! You win!!");
        }*/

        if (!first_win && Money >= 25000) { // firework sound play on the first time the money amount reaches 25000$
            first_win = true;
            clip.stop();
            se.playMusicLocal(fireworkSound, true);
            JOptionPane.showMessageDialog(null, "Congrats! You win!!");
        }

    }
}

