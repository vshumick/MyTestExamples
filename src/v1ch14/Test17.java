package v1ch14;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test17 extends JPanel {
    private int centerX;
    private int centerY;
    private int radius;
    private BufferedImage backgroundTexture;

    public Test17() {
        // Загружаем текстуру для циферблата
        try {
            URL url = new URL("https://celes.club/uploads/posts/2022-08/1661263647_2-celes-club-p-tekstura-tsiferblata-chasov-instagram-2.jpg");
            backgroundTexture = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Определяем центр и радиус часов
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        radius = Math.min(centerX, centerY) - 10;

        // Рисуем фон
        drawBackground(g2);

        // Рисуем циферблат
        drawClockFace(g2);

        // Рисуем стрелки
        LocalTime time = LocalTime.now();
        drawHand(g2, (time.getHour() % 12) * 30 + time.getMinute() / 2, 0.5, Color.BLACK, 10);
        drawHand(g2, time.getMinute() * 6, 0.8, Color.BLACK, 6);
        drawHand(g2, time.getSecond() * 6, 0.9, Color.RED, 3);

        // Обновляем часы каждую секунду
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    private void drawBackground(Graphics2D g2) {
        // Заливаем фон градиентом
        GradientPaint gradient = new GradientPaint(0, 0, new Color(0x87CEFA), 0, getHeight(), new Color(0x4682B4));
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Рисуем тень на циферблате
        g2.setColor(new Color(0, 0, 0, 100));
        g2.fillOval(centerX - radius - 5, centerY - radius - 5, 2 * radius + 10, 2 * radius + 10);
    }

    private void drawClockFace(Graphics2D g2) {
        // Заполняем циферблат текстурой
        //TexturePaint texture = new TexturePaint(backgroundTexture, new Ellipse2D.Float(centerX - radius, centerY - radius, 2 * radius, 2 * radius));
        Rectangle2D.Float rectangle = new Rectangle2D.Float(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        TexturePaint texture = new TexturePaint(backgroundTexture, rectangle);

        g2.setPaint(texture);
        g2.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        // Рисуем деления на циферблате
        g2.setColor(Color.BLACK);
        for (int i = 1; i <= 12; i++) {
            double angle = i * Math.PI / 6;
            int x = (int) (centerX + (radius - 30) * Math.sin(angle));
            int y = (int) (centerY - (radius - 30) * Math.cos(angle));
            g2.drawString(Integer.toString(i), x, y);
        }

        // Рисуем круг по центру
        g2.setColor(Color.BLACK);
        g2.fillOval(centerX - 10, centerY - 10, 20, 20);
    }

    private void drawHand(Graphics2D g2, double angle, double length, Color color, int width) {
        g2.setColor(color);
        g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Вычисляем координаты конца стрелки
        double x = centerX + length * radius * Math.sin(Math.toRadians(angle - 90));
        double y = centerY - length * radius * Math.cos(Math.toRadians(angle - 90));
        Point2D end = new Point2D.Double(x, y);

        // Вычисляем координаты точки, вокруг которой повернется стрелка
        Point2D center = new Point2D.Double(centerX, centerY);

        // Создаем объект AffineTransform для поворота стрелки
        AffineTransform transform = new AffineTransform();
        transform.setToIdentity();
        transform.rotate(Math.toRadians(angle), center.getX(), center.getY());
        Shape shape = transform.createTransformedShape(new Line2D.Double(center, end));

        // Рисуем стрелку
        g2.draw(shape);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Test17 clock = new Test17();
        frame.setContentPane(clock);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

