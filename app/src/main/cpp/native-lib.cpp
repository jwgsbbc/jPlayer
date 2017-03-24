#include <jni.h>
#include <string>
#import <vector>

extern "C" JNIEXPORT jstring JNICALL Java_uk_co_bbc_jplayer_jplayerapp_NativeBridge_staticStringFromJNI(JNIEnv *env, jclass type) {
    std::string hello = "Hello from C++ 1";
    return env->NewStringUTF(hello.c_str());
}

jbyteArray createJavaByteArrayCopy(JNIEnv *env, std::vector<char> &imageBytes);

std::vector<char> readImageBytes(const char *id);

jbyteArray createJavaByteArrayCopy(JNIEnv *env, std::vector<char> &imageBytes) {
    jsize length = (jsize) imageBytes.size();
    jbyteArray pArray = env->NewByteArray(length);
    env->SetByteArrayRegion(pArray, 0, length, (const jbyte *) imageBytes.data());
    return pArray;
}

std::vector<char> readImageBytes(const char *id) {
    return std::vector<char>();
}

extern "C" JNIEXPORT jbyteArray JNICALL Java_uk_co_bbc_jplayer_jplayerapp_NativeBridge_getNativeImage(JNIEnv *env, jclass type, jstring id_) {

    const char *id = env->GetStringUTFChars(id_, 0);

    std::vector<char> imageBytes = readImageBytes(id);

    jbyteArray pArray = createJavaByteArrayCopy(env, imageBytes);

    env->ReleaseStringUTFChars(id_, id);

    return pArray;
}
