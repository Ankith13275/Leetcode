class Solution {
    public String decodeString(String s) {
        
        Stack<String> st = new Stack<>();
        
        Stack<Integer> sI = new Stack<>();
        
        String CurrStr = "";
        int CurrNum = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(ch == '['){
                st.push(CurrStr);
                sI.push(CurrNum);
                CurrNum = 0;
                CurrStr = "";
            }
            else if(ch == ']'){
                int PrevNum = sI.pop();
                String PrevStr = st.pop();
                String New = CurrStr.repeat(PrevNum);
                CurrStr = PrevStr + New; 
            }
            else if(Character.isDigit(ch)){
                CurrNum = CurrNum * 10 + Character.getNumericValue(ch);
            }
            else{
                CurrStr += ch;
            }  
        }
        return CurrStr;
    }
}