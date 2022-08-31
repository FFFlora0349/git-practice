# Modified from the website https://centerkey.com/mac/java/
# This script must be in the same folder as the .java source code of the program

# project structure:

# - (Java Project folder) 
#   - (the src folder) 
#     - AnimalClicker.java
#     - makeAnimalApp.sh
#   - resource
#     - AppIcon.png

# Rename Animal_Clicker.java to AnimalClicker.java!!!
# snakecase class name gives 'invalid mac bundle identifier' with jpackage

echo ">>> Start"
java --version
mkdir AnimalClicker
cd AnimalClicker
cp ../AnimalClicker.java .
#cat AnimalClicker.java
javac --version
javac AnimalClicker.java
ls -o
echo "Main-Class: AnimalClicker" > MainClass.txt
cat MainClass.txt
jar --version
# classfile2jar:
jar cmfv MainClass.txt AnimalClicker.jar *.class
# OR jar -cvfm AnimalClicker.jar manifest.txt *.class
ls -o
#echo "Click the red button (marble) to exit the program."
#java -jar AnimalClicker.jar
cp ../../resource/AppIcon.png .
mv AppIcon.png AnimalClicker.png
# In order for the app icon image to display, the png name must be the same as the jpackage name
sips --version
sips --resampleHeightWidth 120 120 --padToHeightWidth 175 175 \
   AnimalClicker.png --out AnimalClicker-background.png
cp -v AnimalClicker-background.png AnimalClicker-background-darkAqua.png
mkdir AnimalClicker.iconset
sips --resampleHeightWidth 128 128 \
   AnimalClicker.png --out AnimalClicker.iconset/icon_128x128.png
iconutil --convert icns AnimalClicker.iconset
ls -o
mkdir -p package/macos
mv -v *.png *.icns package/macos
jpackage --version
echo "Packaging..."
jpackage --name AnimalClicker --input . --main-jar AnimalClicker.jar \
   --resource-dir package/macos --type pkg
echo "Installer file:"
ls -o *.pkg
open AnimalClicker-1.0.pkg
rm AnimalClicker.java
echo ">>> Done"
