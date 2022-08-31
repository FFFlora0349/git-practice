# From the website https://centerkey.com/mac/java/
echo ">>> Start"
java --version
mkdir ShowTime
cd ShowTime 
#curl --remote-name https://centerkey.com/mac/java/ShowTime.java
cp ../ShowTime.java .
#cat ShowTime.java
javac --version
javac ShowTime.java
ls -o
echo "Main-Class: ShowTime" > MainClass.txt
cat MainClass.txt
jar --version
jar cmfv MainClass.txt ShowTime.jar *.class
ls -o
#echo "Click the red button (marble) to exit the program."
#java -jar ShowTime.jar
#curl --remote-name https://centerkey.com/mac/java/ShowTime.png

cp ../../resource/fireworks.png .
mv fireworks.png ShowTime.png

sips --version
sips --resampleHeightWidth 120 120 --padToHeightWidth 175 175 \
   ShowTime.png --out ShowTime-background.png
cp -v ShowTime-background.png ShowTime-background-darkAqua.png
mkdir ShowTime.iconset
sips --resampleHeightWidth 128 128 \
   ShowTime.png --out ShowTime.iconset/icon_128x128.png
iconutil --convert icns ShowTime.iconset
ls -o
mkdir -p package/macos
cp -v *.png *.icns package/macos
jpackage --version
echo "Packaging..."
jpackage --name ShowTime --input . --main-jar ShowTime.jar \
   --resource-dir package/macos --type pkg
echo "Installer file:"
ls -o *.pkg
open ShowTime-1.0.pkg
rm ShowTime.java
echo ">>> Done"
