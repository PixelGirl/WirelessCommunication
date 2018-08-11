#!/usr/bin/env bash

DIR=$(cd -P -- "$(dirname -- "$0")" && pwd -P)
cd "$DIR"

rm -rf libs/

mkdir -p libs/

cd libs/

echo Downloading CoFH Core...
wget --content-disposition "https://minecraft.curseforge.com/projects/cofhcore/files/2388751/download"

echo Downloading Thermal Foundation...
wget --content-disposition https://minecraft.curseforge.com/projects/thermal-foundation/files/2388753/download

${DIR}/gradlew -p "$DIR" :setupDecomWorkspace

