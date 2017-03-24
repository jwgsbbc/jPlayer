#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL Java_uk_co_bbc_jplayer_jplayerapp_NativeBridge_staticStringFromJNI(JNIEnv *env, jclass type) {
    std::string hello = "Hello from C++ 1";
    return env->NewStringUTF(hello.c_str());
}
