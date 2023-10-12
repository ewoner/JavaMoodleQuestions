package com.ewoner.jcac_etc_questions;

import com.ewoner.jcac_etc_questions.models.questions.Abstracts.Question;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * The MIT License
 *
 * Copyright 2022 Brion Lang.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * Old Main class.  No longer needed but has code for commandline interfacing.
 * 
 * @author Brion Lang
 * @version 0.0.0
 */
@Deprecated
public class Main {

    private List<Question> questions;

    /**
     *
     */
    public Main() {
        questions = new ArrayList<>();
    }

    /**
     *
     * @param args
     */
    public static void main( String[] args ) {
        commandLine( args );
    }

    /**
     *
     * @param args
     */
    public static void commandLine( String[] args ) {
        Main main = new Main();
        main.setQuestions( NewXMLParser.parseXMLfile( "questions-Programming Fundamentals (2021-01R3)-top-20220519-1128.xml" ) );
        main.printQuestions();

        System.out.println( "Hit enter to Exit" );
        try {
            System.err.println( System.in.read() );
        } catch( IOException ex ) {
            Logger.getLogger( Main.class.getName() ).log( Level.SEVERE, null, ex );
        }
    }

    private void printQuestions() {
        for( Question q : questions ) {
            System.out.println( q.getType() );

        }
        System.out.println( "Total size = " + questions.size() );
    }

    private void setQuestions( List<Question> questions ) {
        this.questions = questions;
    }

}
