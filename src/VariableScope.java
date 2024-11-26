import java.util.HashMap;
import java.util.Map;

class VariableScope {
    private final Map<String, Integer> variables = new HashMap<>();
    private final VariableScope parentScope;

    VariableScope(VariableScope parentScope) {
        this.parentScope = parentScope;
    }

    public Integer getVariable(String name) {
        if (variables.containsKey(name)) {
            return variables.get(name);
        } else if (parentScope != null) {
            return parentScope.getVariable(name);
        } else {
            return null;
        }
    }

    void setVariable(String name, int value) {
        variables.put(name, value);
    }

    VariableScope getParentScope() {
        return parentScope;
    }
}