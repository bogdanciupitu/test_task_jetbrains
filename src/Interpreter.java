import java.util.List;

class Interpreter {
    private final List<String> program;
    private int currentLine = 0;
    VariableScope variableScope = new VariableScope(null);

    public Interpreter(List<String> program) {
        this.program = program;
    }

    public void execute() {
        while (currentLine < program.size()) {
            String line = program.get(currentLine).trim();

            if (line.startsWith("print ")) {
                handlePrint(line);
            } else if (line.contains(" = ")) {
                handleAssignment(line);
            } else if (line.equals("scope {")) {
                handleScopesStart();
            } else if (line.equals("}")) {
                handleScopesEnd();
            }
            currentLine++;
        }
    }

    void handlePrint(String line) {
        String variableName = line.substring(6).trim();
        Integer value = variableScope.getVariable(variableName);

        if (value == null) {
            System.out.println("null");
        } else {
            System.out.println(value);
        }
    }

    void handleAssignment(String line) {
        String[] parts = line.split(" = ");
        String variableName = parts[0].trim();
        String value = parts[1].trim();
        Integer x;

        if (Character.isDigit(value.charAt(0))) {
            x = Integer.parseInt(value);
        } else {
            x = variableScope.getVariable(value);
        }
        variableScope.setVariable(variableName, x);
    }

    void handleScopesStart() {
        variableScope = new VariableScope(variableScope);
    }

    void handleScopesEnd() {
        variableScope = variableScope.getParentScope();
    }
}