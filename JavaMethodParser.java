package VSM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaMethodParser {

    List<String> methodStartList = new ArrayList<>();

    private List<String> methodList;
    private List<String> methodNameList;

    private int cnt;

    public JavaMethodParser(String classContents) {
        Pattern classPattern = Pattern.compile("[a-zA-Z]*" + "\\s*class\\s+([_a-zA-Z]+)\\s*\\{(.*)}$", Pattern.DOTALL);

        // now match
        Matcher classMatcher = classPattern.matcher(classContents);
        //System.out.println("    "+classMatcher);
        if (classMatcher.find()) {
            String methodContents = classMatcher.group(2);
            // now parse the methods
            Pattern methodPattern = Pattern.compile("[a-zA-Z]*\\s*[a-zA-Z]+\\s+([_a-zA-Z]+)\\s*?\\(.*?\\)\\s*?\\{");

            Matcher methodMatcher = methodPattern.matcher(methodContents);

            // creating method list and methodName list
            methodList = new ArrayList<>();
            methodNameList = new ArrayList<>();

            while (methodMatcher.find()) {
                String methodName = methodMatcher.group(1);
                String methodStart = methodMatcher.group();
                methodStartList.add(methodStart);
                methodNameList.add(methodName);
            }

            // reversing, cause it'll be easier to split
            // methods from the end of methodContents
            Collections.reverse(methodStartList);
            Collections.reverse(methodNameList);

            String buf = methodContents;
            int i = 0;
            for (String methodStart : methodStartList) {
                String[] t = buf.split(Pattern.quote(methodStart));
                String method = methodStart + t[1];

                methodList.add(method);

                buf = t[0];
                i++;
            }
        } else {
            System.out.println("error: File not found");
            // throw error, cause not even a class
            // or do whatever  think necessary
        }

        // initializing cnt
        cnt = -1;
    }

    public boolean hasMoreMethods() {
        cnt += 1; // cause, cnt is initialized with -1
        return cnt < methodList.size();
    }

    public String getMethodName() {
        return methodNameList.get(cnt);
    }

    public String getMethod() {
        return methodList.get(cnt);
    }

    public int countMethods() {
        return methodList.size();
    }
}
