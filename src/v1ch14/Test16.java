package v1ch14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.JPanel;

    public class Test16 extends JPanel {
        private int centerX;
        private int centerY;
        private int radius;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Определяем центр и радиус часов
            centerX = getWidth() / 2;
            centerY = getHeight() / 2;
            radius = Math.min(centerX, centerY) - 10;

            // Рисуем циферблат
            drawClockFace(g2);

            // Рисуем стрелки
            LocalTime time = LocalTime.now();
            drawHand(g2, (time.getHour() % 12) * 30 + time.getMinute() / 2, 0.5, Color.BLACK);
            drawHand(g2, time.getMinute() * 6, 0.8, Color.BLACK);
            drawHand(g2, time.getSecond() * 6, 0.9, Color.RED);

            // Обновляем часы каждую секунду
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }

        private void drawClockFace(Graphics2D g2) {
            g2.setColor(Color.WHITE);
            g2.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

            g2.setColor(Color.BLACK);
            g2.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

            for (int i = 1; i <= 12; i++) {
                double angle = Math.toRadians(i * 30);
                int x = (int) (centerX + (radius - 25) * Math.sin(angle));
                int y = (int) (centerY - (radius - 25) * Math.cos(angle));
                g2.drawString(String.valueOf(i), x, y);
            }
        }

        private void drawHand(Graphics2D g2, double angle, double length, Color color) {
            g2.setColor(color);

            int x = (int) (centerX + length * radius * Math.sin(Math.toRadians(angle)));
            int y = (int) (centerY - length * radius * Math.cos(Math.toRadians(angle)));

            g2.drawLine(centerX, centerY, x, y);
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame();
            Test16 clock = new Test16();
            frame.setContentPane(clock);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.setVisible(true);
        }
    }

