class DetectCapital {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        if(allUpper(arr) || allLower(arr) || onlyFirstUpper(arr)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean allUpper(char[] str) {
        for(int i = 0; i < str.length; i++) {
            if(!Character.isUpperCase(str[i])) {
                return false;
            }
        }
        return true;
    }
    
    public boolean allLower(char[] str) {
        for(int i = 0; i < str.length; i++) {
            if(!Character.isLowerCase(str[i])) {
                return false;
            }
        }
        return true;
    }
    
    public boolean onlyFirstUpper(char[] str) {
        if(!Character.isUpperCase(str[0])) {
            return false;
        } else {
            for(int i = 1; i < str.length; i++) {
                if(!Character.isLowerCase(str[i])) {
                    return false;
                }
            }
        }
        return true;
    }  
}
