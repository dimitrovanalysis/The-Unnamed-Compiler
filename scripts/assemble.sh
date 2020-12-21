inputPath=${1:-../output/jasmin/FizzBuzz.j}
outputPath=${2:-../output/jasmin/bin/}

java -jar ../jasmin.jar -d $outputPath $inputPath
