package unnamed.frontend;

import unnamed.backend.TypeGenerator;
import unnamed.frontend.parser.UnnamedParser;
import unnamed.frontend.parser.UnnamedParserBaseVisitor;
import unnamed.intermediate.SymTabEntry;
import unnamed.intermediate.SymTabStack;
import unnamed.intermediate.TypeSpec;
import unnamed.intermediate.symtabimpl.Predefined;

import java.io.PrintWriter;
import java.util.ArrayList;

import static unnamed.intermediate.symtabimpl.DefinitionImpl.*;
import static unnamed.intermediate.symtabimpl.SymTabKeyImpl.SLOT;

public class FunctionParamVisitor extends UnnamedParserBaseVisitor<ArrayList<SymTabEntry>> {
    private SymTabStack symTabStack;
    private ArrayList<SymTabEntry> variableIdList;

    public FunctionParamVisitor(SymTabStack symTabStack) {
        this.symTabStack = symTabStack;
    }

    @Override
    protected ArrayList<SymTabEntry> defaultResult() {
        return new ArrayList();
    }

    @Override
    protected ArrayList<SymTabEntry> aggregateResult(ArrayList<SymTabEntry> aggregate, ArrayList<SymTabEntry> nextResult) {
        aggregate.addAll(nextResult);
        return aggregate;
    }

    @Override
    public ArrayList<SymTabEntry> visitVarList(UnnamedParser.VarListContext ctx) {
        variableIdList = new ArrayList();
        return visitChildren(ctx);
    }

    @Override
    public ArrayList<SymTabEntry> visitVarId(UnnamedParser.VarIdContext ctx) {
        String variableName = ctx.IDENTIFIER().toString();

        SymTabEntry variableId = symTabStack.enterLocal(variableName);
        variableId.setDefinition(VALUE_PARM);
        variableId.setAttribute(SLOT, new Integer(variableIdList.size()));
        variableIdList.add(variableId);

        ArrayList value = visitChildren(ctx);
        value.add(variableId);
        return value;
    }

    @Override
    public ArrayList<SymTabEntry> visitTypeId(UnnamedParser.TypeIdContext ctx) {
        String identifier = ctx.IDENTIFIER().toString();
        SymTabEntry entry = symTabStack.lookup(identifier);
        TypeSpec type = Predefined.undefinedType;

        if (entry != null && entry.getDefinition() == TYPE) {
            type = entry.getTypeSpec();
        }

        for (SymTabEntry id : variableIdList) {
            id.setTypeSpec(type);
        }

        return visitChildren(ctx);
    }
}
