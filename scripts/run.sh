name=${1:-FizzBuzz}
path=${2:-../output/jasmin/bin/}
SCRIPTPATH="$( cd "$(dirname "$0")" ; pwd -P )"

cd $path
java -cp .:$SCRIPTPATH/../PascalRTL.jar $name | tee $SCRIPTPATH/../output/output_run.txt
