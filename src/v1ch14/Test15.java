package v1ch14;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class Test15 extends JPanel {

    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    public Test15() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        Timer timer = new Timer(1000, e -> repaint());
        timer.start();
    }

    private void drawClock(Graphics g) {
        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;
        int radius = WIDTH / 3;
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        for (int i = 1; i <= 12; i++) {
            double angle = i * Math.PI / 6;
            int x = (int) (centerX + 0.8 * radius * Math.sin(angle));
            int y = (int) (centerY - 0.8 * radius * Math.cos(angle));
            g.drawString(String.valueOf(i), x, y);
        }
    }

    private void drawHands(Graphics g) {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;
        int hourHandLength = WIDTH / 5;
        int minuteHandLength = WIDTH / 3;
        int secondHandLength = WIDTH / 3;
        double hourAngle = (hour % 12 + minute / 60.0) * 2 * Math.PI / 12;
        double minuteAngle = (minute + second / 60.0) * 2 * Math.PI / 60;
        double secondAngle = second * 2 * Math.PI / 60;
        int hourX = (int) (centerX + hourHandLength * Math.sin(hourAngle));
        int hourY = (int) (centerY - hourHandLength * Math.cos(hourAngle));
        int minuteX = (int) (centerX + minuteHandLength * Math.sin(minuteAngle));
        int minuteY = (int) (centerY - minuteHandLength * Math.cos(minuteAngle));
        int secondX = (int) (centerX + secondHandLength * Math.sin(secondAngle));
        int secondY = (int) (centerY - secondHandLength * Math.cos(secondAngle));
        g.drawLine(centerX, centerY, hourX, hourY);
        g.drawLine(centerX, centerY, minuteX, minuteY);
        g.setColor(Color.RED);
        g.drawLine(centerX, centerY, secondX, secondY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawClock(g);
        drawHands(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Test15());
        frame.pack();
        frame.setVisible(true);
    }
}
