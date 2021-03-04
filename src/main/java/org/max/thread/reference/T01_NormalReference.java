package org.max.thread.reference;

import java.io.IOException;

@SuppressWarnings("unused")
public class T01_NormalReference {
    
	public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc(); //DisableExplicitGC

        System.in.read();
    }
}
