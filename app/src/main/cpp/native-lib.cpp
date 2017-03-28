#include <jni.h>
#include <string>
#import <vector>
#include "TestNewClass.h"
#include "Poco/Timestamp.h"
#include "Poco/Net/HTTPClientSession.h"
#include "Poco/Net/HTTPRequest.h"
#include "Poco/Net/HTTPResponse.h"

using Poco::Timestamp;
using Poco::Net::HTTPClientSession;
using Poco::Net::HTTPRequest;
using Poco::Net::HTTPResponse;
using Poco::Net::HTTPMessage;

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

    HTTPClientSession session;
    HTTPRequest request(HTTPRequest::HTTP_GET, "http://iplayer-mobile-appconfig.files.bbci.co.uk/config/iplayer/android/4.22.2/config.json", HTTPMessage::HTTP_1_1);

    HTTPResponse response;

    try {
        session.sendRequest(request);
    }
    catch (const std::exception& e) {
        const char *string = e.what();
        int i=0;
    }

    std::istream& rs = session.receiveResponse(response);
    HTTPResponse::HTTPStatus status = response.getStatus();

    TestNewClass testNewClass;

    Timestamp timestamp;
    
    timestamp.update();

    time_t i = timestamp.epochTime();

    char a = testNewClass.getOne();

    auto vector1 = std::vector<char>();

    vector1.push_back(a);

    return vector1;
}

extern "C" JNIEXPORT jbyteArray JNICALL Java_uk_co_bbc_jplayer_jplayerapp_NativeBridge_getNativeImage(JNIEnv *env, jclass type, jstring id_) {

    const char *id = env->GetStringUTFChars(id_, 0);

    std::vector<char> imageBytes = readImageBytes(id);

    jbyteArray pArray = createJavaByteArrayCopy(env, imageBytes);

    env->ReleaseStringUTFChars(id_, id);

    return pArray;
}
