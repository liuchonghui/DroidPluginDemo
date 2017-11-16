 #!/bin/sh
adb shell rm -rf /data/data/com.host/Plugin/*
adb push ./plugin-debug.apk /data/data/com.host/Plugin/ 
