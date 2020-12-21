package unnamed;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

//import unnamed.frontend.*;
import unnamed.backend.Pass1Visitor;
import unnamed.backend.Pass2Visitor;
import unnamed.frontend.FunctionParamVisitor;
import unnamed.intermediate.SymTabFactory;
import unnamed.intermediate.SymTabStack;
import unnamed.intermediate.symtabimpl.Predefined;
import unnamed.message.CompileError.CompileError;
import unnamed.message.Message;
import unnamed.message.MessageHandler;
import unnamed.message.MessageListener;
import unnamed.message.MessageType;


public class Unnamed implements MessageListener {
    private static String programName = "placeholder";
    private static String outputPath = "./";
    public static final MessageHandler ml = new MessageHandler();

    public static void main(String[] args) throws Exception {
        String inputFile = null;

        if (args.length > 0) inputFile = args[0];
        InputStream is = (inputFile != null)
                ? new FileInputStream(inputFile)
                : System.in;

        if (inputFile != null) {
            String[] inputArray = inputFile.split("/|\\\\");
            outputPath = "";
            for (int i = 0; i < inputArray.length - 2; i++) {
                outputPath += inputArray[i];
            }
            programName = inputArray[inputArray.length - 1].split("\\.")[0];
        }

        if (args.length > 1) outputPath = args[1];
        CharStream cs = CharStreams.fromStream(is);

        Unnamed unnamed = new Unnamed();
        unnamed.compile(cs);
    }

    public Unnamed() {
        ml.addListener(this);
    }

    public Integer compile(CharStream cs) {
        System.out.println("------ Parsing Start ------");
        UnnamedLexer lexer = new UnnamedLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        UnnamedParser parser = new UnnamedParser(tokens);
        ParseTree tree = parser.program();

        System.out.println("Done");

        // Create the assembly output file.
        PrintWriter jFile;
        try {
            jFile = new PrintWriter(new FileWriter(outputPath + programName + ".j"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
        System.out.println("\n------ Compilation Start ------");

        // Create and initialize the symbol table stack.
        SymTabStack symTabStack;
        symTabStack = SymTabFactory.createSymTabStack();
        Predefined.initialize(symTabStack);

        //Compile in 2 passes

        Pass1Visitor pass1 = new Pass1Visitor(jFile, symTabStack);
        Integer value = pass1.visit(tree);

        if (value  == 0) {
            Pass2Visitor pass2 = new Pass2Visitor(jFile, symTabStack);
            value = value + pass2.visit(tree);
            if (value == 0){
                System.out.print("Done\nCompiled \'" + programName + "\' successfully");
            } else {
                System.out.print("Could not compile \'" + programName + "\': found " + value + " errors");
            }
        } else  {
            System.out.print("Could not compile \'" + programName + "\': found " + value + " errors");
        }
        return value;
    }

    @Override
    public void messageReceived(Message message) {
        if (message.getType() == MessageType.COMPILE_ERROR) {
            System.out.print("COMPILING ERROR: ");
            CompileError err = (CompileError) message.getBody();
            switch (err.errorType) {
                case ASSIGN_FINAL:
                    System.out.println("Cannot assign a value to final variable" + err.context[0]);
                    break;
                case ASSIGN_ERROR:
                    System.out.println("Cannot assign a value to: " + err.context[0] + " (Not a variable)");
                    break;
                case INCOMPARABLE:
                    System.out.println("Cannot compare types " + err.context[1] + " and " + err.context[2] + " in: " + err.context[0]);
                    break;
                case UNDEFINED_VAR:
                    System.out.println("Variable " + err.context[0] + " was never defined");
                    break;
                case UNDEFINED_FUNC:
                    System.out.println("Function " + err.context[0] + " was never defined");
                    break;
                case UNDEFINED_TYPE:
                    System.out.println("Type " + err.context[0] + " was never defined");
                    break;
                case UNMATCHING:
                    System.out.println("Cannot use types " + err.context[1] + " and " + err.context[2] + " in: " + err.context[0]);
                    break;
            }
        }
    }

    public static String getProgramName() {
        return programName;
    }
}
