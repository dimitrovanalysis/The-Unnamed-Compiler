file=${1:-FizzBuzz}

./compile.sh ../sample-programs/$file.unnamed | tee ../output/output.txt
printf "\n\n------ Assemble ------\n" | tee -a ../output/output.txt
./assemble.sh ../output/jasmin/$file.j | tee -a ../output/output.txt
