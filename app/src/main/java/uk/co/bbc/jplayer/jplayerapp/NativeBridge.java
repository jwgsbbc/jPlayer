package uk.co.bbc.jplayer.jplayerapp;

public class NativeBridge {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public static native String staticStringFromJNI();
}

