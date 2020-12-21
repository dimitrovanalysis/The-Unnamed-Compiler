file=${1:-../sample-programs/FizzBuzz.unnamed}
outputPath=${2:-../output/jasmin/}

cd ../bin/production/compiler-unnamed/
java unnamed.Unnamed ../../../scripts/$file ../../../scripts/$outputPath
cd - > /dev/null

