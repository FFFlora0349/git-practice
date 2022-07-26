import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;
import java.io.*;

class Sound
{
    public static void main(String[] args) throws Exception
    {
        //URL file = new URL("file:./flyby1.wav");
        //URL file = new URL("file:c:/users/netro/java/flyby1.wav");
        //URL file = new URL("https://www.wavsource.com/snds_2020-10-01_3728627494378403/sfx/air_raid.wav");
        URL file = new URL("http://www.guineapigs-online.com/sounds/futter.wav");
        AudioInputStream sound = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(sound);

        JButton button = new JButton("Play Clip");
        button.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                clip.setFramePosition(0);
                clip.start();
            }
        });

        JOptionPane.showMessageDialog(null, button);
    }
}
