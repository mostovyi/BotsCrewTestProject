package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {

    public String[] parseLine(String[] args) {

        List<String> line = new ArrayList<>();
        line.addAll(Arrays.asList(args));

        if(line.contains("Who") && line.contains("department"))
            return new String[]{"head", line.get(5)};
        else if(line.contains("Show") && line.contains("statistics"))
            return new String[]{"statistics", line.get(1)};
        else if(line.contains("average") && line.contains("salary"))
            return new String[]{"salary", line.get(7)};
        else if(line.contains("count") && line.contains("employee"))
            return new String[]{"count", line.get(5)};
        else if(line.contains("Global") && line.contains("search"))
            return new String[]{"search", line.get(3)};

        return new String[0];
    }
}
