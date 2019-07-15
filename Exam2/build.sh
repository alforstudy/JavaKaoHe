#!/bin/bash
echo 开始编译文件
mvn clean package -Dmaven.test.skip=true
echo 编译完成完成