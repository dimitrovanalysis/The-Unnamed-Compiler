package unnamed.backend;

import unnamed.intermediate.TypeSpec;
import unnamed.intermediate.typeimpl.TypeChecker;

public class TypeGenerator {
    public static String getTypeIndicator(TypeSpec typeSpec) {
        if (TypeChecker.isInteger(typeSpec)) {
            return "I";
        } else if (TypeChecker.isReal(typeSpec)) {
            return "F";
        } else if (TypeChecker.isString(typeSpec)) {
            return "Ljava/lang/String;";
        } else if (TypeChecker.isBoolean(typeSpec)) {
            return "Z";
        } else if (TypeChecker.isChar(typeSpec)) {
            return "C";
        }
        return "?";
    }

    /*public static boolean isComparable(TypeSpec type1, TypeSpec type2, boolean isEqOp){
        if(isEqOp && type1 == type2) return true;
        if(type1 == Predefined.integerType || type1 == Predefined.realType){
            if(type2 == Predefined.integerType || type2 == Predefined.realType) return true;
        }
        return false;
    }*/

    public static String getTypeReturnStatement(TypeSpec typeSpec) {
        if (TypeChecker.isInteger(typeSpec)) {
            return "ireturn";
        } else if (TypeChecker.isReal(typeSpec)) {
            return "freturn";
        } else if (TypeChecker.isBoolean(typeSpec)) {
            return "ireturn";
        } else if (TypeChecker.isChar(typeSpec)) {
            return "ireturn";
        }
        return "areturn";
    }
}
