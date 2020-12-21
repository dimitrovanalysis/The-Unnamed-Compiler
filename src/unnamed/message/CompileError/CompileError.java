package unnamed.message.CompileError;

public class CompileError {
    public final String[] context;
    public final CompileErrorType errorType;

    public CompileError(String[] context, CompileErrorType errorType) {
        this.context = context;
        this.errorType = errorType;
    }
}

