import java.awt.*;import java.util.*;import javax.swing.*;import java.io.*;import javax.imageio.*;import java.awt.geom.*;import java.awt.image.*;public class RotateAndScale extends JPanel{    private Image image;    public RotateAndScale(Image image)    {        this.image = image;    }    @Override    protected void paintComponent(Graphics g)    {         super.paintComponent(g);         // create the transform, note that the transformations happen         // in reversed order (so check them backwards)         AffineTransform at = new AffineTransform();         // 4. translate it to the center of the component         at.translate(getWidth() / 2, getHeight() / 2);         // 3. do the actual rotation         at.rotate(Math.toRadians(45));         // 2. scale the image         at.scale(0.5, 0.5);         // 1. translate the object to rotate around the center         at.translate(-image.getWidth(this) / 2, -image.getHeight(this) / 2);         // draw the image         Graphics2D g2 = (Graphics2D)g.create();         g2.drawImage(image, at, null);         g2.dispose();         // continue drawing other stuff (non-transformed)         //...    }    private static void createAndShowGUI()    {        try        {            BufferedImage image = ImageIO.read(new File(&quot;splash.gif&quot;));            JFrame frame = new JFrame(&quot;SSCCE&quot;);            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            frame.add( new RotateAndScale(image));            frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);            frame.setSize(400, 400);            frame.setLocationByPlatform( true );            frame.setVisible( true );        }        catch(Exception e) { System.out.println(e); }    }    public static void main(String[] args) throws Exception    {        java.awt.EventQueue.invokeLater( () -> createAndShowGUI() );    }}