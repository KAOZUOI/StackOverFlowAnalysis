@Override    protected void paintComponent(Graphics g) {        super.paintComponent(g);        Graphics2D g2 = (Graphics2D)g.create();                int w = getWidth();        int h = getHeight();        int imageWidth = this.image.getWidth();        int imageHeight = this.image.getHeight();        AffineTransform at = new AffineTransform();                at.translate(w/2, h/2);        at.scale(scale, scale);        at.translate(-imageWidth/2, -imageHeight/2);        g2.drawImage(image, at, null);        g2.dispose();    }