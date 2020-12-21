file=${1:-../sample-programs/FizzBuzz.unnamed}
[ ! -d ../output ] && mkdir ../output
cd ../bin/production/compiler-unnamed
java unnamed.Unnamed ../../../scripts/$file > ../../../output/output.txt
java org.antlr.v4.gui.TestRig unnamed.frontend.parser.Unnamed program -ps ../../../output/tree.ps ../../../scripts/$file
convert -colorspace sRGB -density 300 ../../../output/tree.ps -background white -flatten -resize 2048x2048 -units pixelsperinch -density 72 ../../../output/tree.png
rm ../../../output/tree.ps