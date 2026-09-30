class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            // Current directory or multiple slashes
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Parent directory
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Normal directory/file name
            else {
                stack.push(part);
            }
        }

        // Build the canonical path
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        // If stack is empty, we're at root
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}