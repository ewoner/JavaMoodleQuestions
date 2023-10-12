/*MIT License

Copyright (c) 2022 Brion Lang

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.ewoner.JavaLoggers.TextAreaLogger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;
import java.util.logging.Formatter;
import javax.swing.JTextArea;

/**
 * Formats and creates a logger for a JTextArea. Several classes included
 * in this single file. May move them out later.
 * 
 * 
 * @author Brion Lang
 * @version 0.0.0
 */
public class TextAreaLogger {

    static private TextAreaLogger instance = null;
    static private Logger logger;

    private final JTextArea textArea;
    private Logger instatnceLogger;

    /**
     *
     * @param textArea
     */
    public TextAreaLogger(JTextArea textArea) {
        this.textArea = textArea;
        this.instatnceLogger = Logger.getLogger(TextAreaLogger.class.getName());
    }

    /**
     *
     * @param textArea
     * @return
     */
    static public Logger initLogger(JTextArea textArea) {
        instance = new TextAreaLogger(textArea);
        logger = instance.getInstanceLogger();
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        OutputStream os = new TextAreaOutputStream(textArea);
        logger.addHandler(new TextAreaHandler(os));
        logger.info("Programming started....");
        return logger;
    }

    /**
     *
     * @return
     */
    static public Logger getLogger() {
        if (instance == null && instance.hasTextArea()) {
            System.err.println("Logger tool not set up.  Exiting program.");
            System.exit(1);
        }
        return instance.getInstanceLogger();
    }

    private Logger getInstanceLogger() {
        return this.instatnceLogger;
    }

    /**
     *
     * @return
     */
    public boolean hasTextArea() {
        return this.textArea != null;
    }
}

class TextAreaHandler extends StreamHandler {

    // private Writer writer;
    protected TextAreaHandler(OutputStream os) {
        super();
        configure();
        setOutputStream(os);
        // writer = new OutputStreamWriter( os );
        // setFormatter( new TextAreaFormatter() );
    }

    @Override
    public synchronized void publish(LogRecord record) {
        super.publish(record);
        flush();
    }

    @Override
    public synchronized void close() {
        flush();
    }

    private void configure() {
        // setFormatter( new SimpleFormatter() );
        setFormatter(new TextAreaFormatter());
        try {
            setEncoding("UTF-8");
        } catch (IOException ex) {
            try {
                setEncoding(null);
            } catch (IOException ex2) {
                // doing a setEncoding() with null should always work.
                ex2.printStackTrace(System.err);
                System.exit(1);
            }
        }
    }
}

class TextAreaOutputStream extends OutputStream {

    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private final JTextArea textArea;

    protected TextAreaOutputStream(JTextArea textArea) {
        super();
        this.textArea = textArea;
    }

    @Override
    public void flush() throws IOException {
        textArea.append(buffer.toString("UTF-8"));
        buffer.reset();
    }

    @Override
    public void write(int b) throws IOException {
        buffer.write(b);
    }

}

class TextAreaFormatter extends Formatter {

    String format = "%1$s: %2$s [%3$tc]%n";

    @Override
    public String format(LogRecord lr) {
        return String.format(format, lr.getLevel(), lr.getMessage(), new Date(lr.getMillis()));
    }
}