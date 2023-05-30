public void asposeTranslate(String fileName) throws IOException {        Locale.setDefault(new Locale(&quot;en-us&quot;));        // Load presentation        Presentation pres = new Presentation(URL + &quot;/&quot; + fileName);                // Loop through each slide        for (ISlide slide : pres.getSlides()) {            // Get all text frames in the slide            ITextFrame[] tf = SlideUtil.getAllTextBoxes(slide);            for (int i = 0; i < tf.length; i++) {                for (IParagraph para : tf[i].getParagraphs()) {                                        for (IPortion port : para.getPortions()) {                        String originText = port.getText();                        String newText = translateText(originTexmakes); // method make a new text                        port.setText(newText); // replace with new text                    }                }            }        }        pres.save(URL + &quot;/new_&quot; + fileName, SaveFormat.Pptx);    }