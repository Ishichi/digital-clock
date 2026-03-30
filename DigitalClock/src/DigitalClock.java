import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.*;
import java.util.*;

public class DigitalClock extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat, dayFormat, dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time, day, date;

    DigitalClock()
    {
        this.setTitle("Digital Clock project v1.0 BSIT 1-1 2025");
        this.setSize(800, 300);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        timeFormat = new SimpleDateFormat("hh:mm:ss d");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

        timeLabel = new JLabel();
        timeLabel.setForeground(new Color(0xFF00));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setFont(new Font("Consolas",Font.PLAIN,175));
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Consolas", Font.PLAIN, 35));
        
        
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);

        setTime();
    }

    public void setTime()
    {
        while (true) 
        {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);    

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            dayLabel.setForeground(Color.WHITE);
            
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            dateLabel.setForeground(Color.GRAY);

            try 
            {
                Thread.sleep(1100);
            }   catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new DigitalClock();
    }
}
